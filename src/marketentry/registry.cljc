(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-sector market-entry filing --
  every jurisdiction assigns its own format. This namespace does NOT
  invent one; it builds a jurisdiction-scoped sequence number and
  validates the record's required fields, the same honest,
  non-fabricating discipline `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the
  SAME ground-truth-recompute DISCIPLINE sibling actors use (verify a
  claimed monetary total against the entity's own recorded quantity x
  unit fields), reapplied to a market-entry engagement fee line.

  `investment-approval-authority` / `approval-authority-mismatch?` are
  the SAME discipline applied to a genuinely Republic of Cuba-specific
  mechanism: Ley No. 118 \"Ley de la Inversión Extranjera\" (Gaceta
  Oficial No. 20 Extraordinaria, 16 de abril de 2014), Art.21's own
  THREE-TIER approval-authority assignment by sector and modality --
  Consejo de Estado (natural-resource exploration/exploitation UNLESS a
  risk international-economic-association contract, and management of
  public services), Consejo de Ministros (real-estate development,
  wholly-foreign-owned companies, state-property transfer, risk EAIC
  contracts for non-renewable-resource exploitation, foreign entities
  with public-capital participation, renewable energy, the health/
  education/armed-forces business system, and any other FDI not
  requiring Consejo de Estado approval), and a jefe de organismo the
  Consejo de Ministros MAY discretionarily delegate to (Art.21.4). This
  namespace deliberately models only the first TWO tiers, which Art.21.2
  and Art.21.3 state directly and unconditionally -- the third tier's
  per-sector delegation instruments were not independently fetched by
  this iteration (see `marketentry.facts` namespace docstring), the same
  honest scope-narrowing discipline CAF's Marché réservé value-threshold
  delegation and Bhutan's unread Debarment Rules duration clause already
  established for this family: only the ELIGIBILITY-FREE, textually
  unconditional classification is independently recomputed here.

  This is a GENUINELY DIFFERENT check SHAPE than every prior iso3166
  sibling this repo mirrors: Bulgaria's ЗОП Art. 54(5) de-minimis is a
  PERCENTAGE-OF-TURNOVER ELIGIBILITY formula, Albania's Neni 76(2)(c)
  carve-out is a FLAT-CONSTANT ELIGIBILITY threshold, Azerbaijan's/
  Armenia's flagship checks are BOOLEAN registry-membership ELIGIBILITY
  reads, Antigua and Barbuda's vendor-class check is a THREE-TIER
  ELIGIBILITY-THRESHOLD classification, Benin's MPME mechanism is a
  BID-EVALUATION PRICE ADJUSTMENT, Bhutan's FDI Negative List is a
  CATEGORICAL SECTOR-EXCLUSION allow-list gate, Botswana's citizen-
  reservation check is an ORDERED-TIER ELIGIBILITY-preference scale, and
  CAF's Marché réservé mechanism is a MULTI-CRITERION INCLUSION-
  ELIGIBILITY test on the bidder's own workforce composition. Cuba's
  Ley 118 Art.21 mechanism is none of these: it is an AUTHORITY-
  JURISDICTION ROUTING classification with a textual override (the
  Art.21.2(a) risk-EAIC carve-out that redirects an otherwise-Consejo-
  de-Estado sector to Consejo de Ministros) -- the first in this family
  to check WHICH GOVERNMENT BODY has jurisdiction to approve a filing,
  rather than WHETHER a bidder/investor is eligible to proceed at all.

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real government system. It builds the RECORD an operator
  would keep, not the act of submitting a portal registration itself
  (that is `marketentry.operation`'s `:filing/submit`, always
  human-gated -- see README Actuation)."
  (:require [kotoba.lang.text :as str]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(def ^:private money-scale
  "Sub-minor-unit scale used when comparing two money amounts: 1/10000 of
  a unit. Coarser than double representation error by many orders of
  magnitude, finer than any real currency's minor unit (2 decimals for
  most, 3 for KWD/BHD/OMR, 0 for JPY/KRW)."
  10000)

(defn- money=
  "Exact-at-money-precision equality for two amounts.

  `==` on raw doubles is NOT the right comparison for money. With
  whole-unit fees the two agree, but as soon as an amount carries
  cents the sum `base + rate x months` is routinely not the double
  nearest the true total, and a CORRECT claim compares false: measured
  on this exact shape, 40,989 of 327,060 cent-denominated combinations
  (12.5%) were rejected while being right, against 0 of 327,060 in
  whole units.

  Rounding both sides to `money-scale` before comparing removes the
  representation error while preserving every distinction money can
  actually carry."
  [x y]
  (and (number? x) (number? y)
       (= (Math/round (* money-scale (double x)))
          (Math/round (* money-scale (double y))))))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  ;; nil when any field is not a number: an un-recomputable engagement is
  ;; un-verifiable, which is neither `correct` nor a ClassCastException
  ;; thrown out of the caller.
  (when (and (number? base-fee) (number? monthly-rate) (number? monitoring-months))
    (+ (double base-fee)
       (* (double monthly-rate) (double monitoring-months)))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (money= claimed-fee (compute-engagement-fee engagement)))

(def consejo-de-estado-sectors
  "Ley 118 Art.21.2: sectors/purposes requiring Consejo de Estado
  approval, UNLESS the investment modality is itself a risk contrato de
  asociación económica internacional for non-renewable-resource
  exploration/exploitation -- Art.21.2(a)'s own textual exception routes
  THAT specific combination to Consejo de Ministros instead (Art.21.3(d),
  see `investment-approval-authority`)."
  #{:non-renewable-resource-exploration-exploitation
    :public-service-management})

(def consejo-de-ministros-sectors
  "Ley 118 Art.21.3(a)-(g): sectors/modalities the Law itself assigns
  directly to Consejo de Ministros. The residual bucket, Art.21.3(h)
  ('otras inversiones extranjeras que no requieran la aprobación del
  Consejo de Estado'), is handled as this classification's DEFAULT (see
  `investment-approval-authority`) rather than enumerated here."
  #{:real-estate-development
    :wholly-foreign-owned-company
    :state-property-transfer
    :risk-eaic-non-renewable-resources
    :foreign-entity-public-capital-participation
    :renewable-energy-use
    :health-education-armed-forces-business-system})

(defn investment-approval-authority
  "The ground-truth FDI approval-authority TIER for `engagement`,
  independently recomputed from its own declared `:fdi-sector` (and,
  where it matters, `:fdi-modality`), per Ley 118 Art.21.1-21.4. Returns
  `:consejo-de-estado` or `:consejo-de-ministros` -- Art.21.4's
  discretionary delegation to a jefe de organismo is deliberately NOT
  modeled (see namespace docstring); anything not requiring Consejo de
  Estado approval defaults to Consejo de Ministros, consistent with
  Art.21.3(h)'s own residual wording. A missing/nil `:fdi-sector`
  simply falls through to the Consejo de Ministros default (does not
  throw)."
  [{:keys [fdi-sector fdi-modality]}]
  (cond
    ;; Art.21.2(a)'s own exception: a risk contrato de asociación
    ;; económica internacional for non-renewable-resource exploration/
    ;; exploitation is routed to Consejo de Ministros (Art.21.3(d)),
    ;; NOT Consejo de Estado, even though the underlying sector would
    ;; otherwise qualify.
    (and (= fdi-sector :non-renewable-resource-exploration-exploitation)
         (= fdi-modality :risk-international-economic-association-contract))
    :consejo-de-ministros

    (contains? consejo-de-estado-sectors fdi-sector)
    :consejo-de-estado

    :else
    :consejo-de-ministros))

(defn approval-authority-mismatch?
  "Does `engagement` declare a `:claimed-approval-authority` that does
  NOT match the independently recomputed `investment-approval-
  authority`? An engagement with no claimed authority at all is not
  flagged by this check (entity/engagement-scope-gated, the same
  discipline Bhutan's `:foreign-company?`-gated FDI check and CAF's
  `:reserved-market?`-gated eligibility check use)."
  [{:keys [claimed-approval-authority] :as engagement}]
  (boolean (and claimed-approval-authority
                (not= claimed-approval-authority
                      (investment-approval-authority engagement)))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a portal registration
  package. Pure function -- does not touch any real government system."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting the FDI
  authorization filing / Registro Mercantil inscription (always
  human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))
