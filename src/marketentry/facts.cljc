(ns marketentry.facts
  "Per-jurisdiction public-sector market-entry regulatory catalog -- the
  G2-style spec-basis table the Market-Entry Compliance Governor checks
  every `:jurisdiction/assess` proposal against ('did the advisor cite an
  OFFICIAL public source for this jurisdiction's requirements, or did it
  invent one?').

  Republic of Cuba's real market-entry surface is genuinely NOT the
  'normal market economy' shape every other iso3166 sibling in this
  fleet models (a companies registry + a competitive-tender e-procurement
  portal). Cuba is a centrally-planned economy: almost all economic
  activity is via state enterprises, and inbound FOREIGN market entry
  runs through a case-by-case government AUTHORIZATION regime, not a
  competitive-bid/registration regime. This iteration investigated this
  directly (curl/pandoc/pdftotext-verified 2026-07-22) rather than
  assuming a Bhutan/Botswana/CAF-shaped system applies, and every claim
  below cites a source this iteration actually fetched and read:

  - **Foreign investment is governed by Ley No. 118 'Ley de la Inversión
    Extranjera' (Foreign Investment Law), dada (approved/dated) 29 de
    marzo de 2014, published in Gaceta Oficial No. 20 Extraordinaria, LA
    HABANA, MIÉRCOLES 16 DE ABRIL DE 2014** (own primary text
    downloaded directly as a real, machine-readable PDF -- NOT a scanned
    image -- from `gacetaoficial.gob.cu`'s own hosting and read via
    `pdftotext -layout`; own cover states verbatim 'Gaceta Oficial No.
    20 Extraordinaria de 16 de abril de 2014' / 'EXTRAORDINARIA LA
    HABANA, MIÉRCOLES 16 DE ABRIL DE 2014 AÑO CXII'). This repeals the
    prior Ley No. 77 'Ley de la Inversión Extranjera' of 5 September
    1995, Decreto-Ley No. 165/1996 'De las Zonas Francas y Parques
    Industriales', and Acuerdos 5279/2004, 5290/2004 and 6365/2008 of
    the Comité Ejecutivo del Consejo de Ministros (own text, Disposición
    Final Segunda, read directly). NOTE: the Gaceta site's OWN node
    metadata field for this issue states a conflicting 'Fecha:
    16/05/2014' -- this iteration trusts the PRIMARY document's own
    repeated in-body dating ('16 de abril de 2014', appearing on both
    the masthead and the running page footer of every page read) over
    the secondary metadata field, and flags the metadata's own
    inconsistency here rather than silently picking one.
  - **There is NO dedicated e-procurement / self-service FDI portal**
    (the SIGMAP/egp.gov.bt/e-Vergabe shape every market-economy sibling
    in this fleet has). Foreign-investment market entry is an
    EXECUTIVE-BRANCH AUTHORIZATION pipeline, not a competitive-tender or
    self-registration system, confirmed directly from Ley 118's own
    Chapter V/Chapter IV-of-the-Reglamento text:
    1. Proposals are identified/presented by the sponsoring órgano,
       Organismo de la Administración Central del Estado or entidad
       nacional to the **Ministerio del Comercio Exterior y la
       Inversión Extranjera (MINCEX)** (Ley 118 Art.11.3-11.4, own
       text: 'tienen la obligación... de identificar y presentar al
       Ministerio del Comercio Exterior y la Inversión Extranjera las
       propuestas de negocios con inversión extranjera').
    2. MINCEX admits only complete filings (Decreto 325/2014 Reglamento
       Art.33, own text: 'Solo serán admitidas por el Ministerio del
       Comercio Exterior y la Inversión Extranjera las solicitudes que
       se presentan con la información establecida en este Reglamento;
       procediendo en su defecto a no aceptarlas y devolverlas dentro
       de los cinco (5) días naturales siguientes').
    3. Admitted proposals are referred to the **Comisión de Evaluación
       de Negocios con Inversión Extranjera**, which evaluates within 15
       calendar days (Reglamento Art.34.1, own text: 'se remiten en
       consulta a la Comisión de Evaluación de Negocios con Inversión
       Extranjera; convocando a su análisis en su sesión más inmediata.
       Esta Comisión evalúa las solicitudes en un plazo de quince (15)
       días naturales').
    4. MINCEX then presents the evaluated file to whichever of THREE
       real, textually-distinct approval authorities Ley 118 Art.21.1
       assigns it to by SECTOR and MODALITY (own text, quoted verbatim
       below under `reserved-market`-equivalent flagship basis) -- a
       decision within 60 days for Consejo de Estado/Consejo de
       Ministros filings, 45 days for filings delegated to a jefe de
       organismo (Reglamento Art.35.1-35.3, own text read directly).
    5. Once authorized, the resulting empresa mixta / contrato de
       asociación económica internacional / empresa de capital
       totalmente extranjero MUST register in the **Registro
       Mercantil** to acquire legal personality / enter into force --
       confirmed independently in BOTH Ley 118's own text (Art.14.6:
       'La empresa mixta adquiere personalidad jurídica cuando se
       inscribe en el Registro Mercantil'; Art.15.5 for the contrato de
       asociación económica internacional; Art.16.2 for the empresa de
       capital totalmente extranjero) AND Decreto-Ley No. 226 'Del
       Registro Mercantil' own Art.2.1 (as modified), which lists as
       registrable subjects '(c) las empresas mixtas... (d) los
       contratos de Asociación Económica Internacional; (e) las
       empresas de capital totalmente extranjero...' -- this iteration
       fetched Decreto-Ley 226's own consolidated/updated PDF text
       directly (`gacetaoficial.gob.cu`, 'ACTUALIZADO 17 DE ABRIL DE
       2023') rather than relying only on a secondary summary.
  - **Registro Mercantil is administered by the Ministerio de Justicia**
    (own Art.1.1, read directly: 'El Registro Mercantil está a cargo del
    Ministerio de Justicia y se integra por el Registro Mercantil
    Central y los Registros Mercantiles Territoriales' -- Central in
    Havana with national jurisdiction, Territoriales with provincial
    jurisdiction). Decreto-Ley 226 is itself dada 6 de diciembre de 2001
    (Consejo de Estado, signed Fidel Castro Ruz), published Gaceta
    Oficial Ordinaria No. 2, 10 de enero de 2002 -- this iteration notes
    that `minjus.gob.cu`'s OWN secondary summary page for this service
    states an internally-inconsistent '6 de enero del año 2001' /
    '10 de enero de 2002' pairing; the PRIMARY decree text (fetched
    directly from `gacetaoficial.gob.cu`) is unambiguous on '6 de
    diciembre de 2001', which this catalog trusts over the ministry's
    own secondary summary page.
  - **Tax registration is the Oficina Nacional de Administración
    Tributaria (ONAT)**, confirmed as a currently-active issuing body
    directly from `gacetaoficial.gob.cu`'s own official
    'Organismo emisor' taxonomy (option value 546, listing resolutions
    from 1996 through 2025). The tax identifier is the **NIT (Número de
    Identificación Tributaria)**: this iteration fetched Gaceta Oficial
    No. 97 Ordinaria de 2025 (published 23/12/2025, own masthead read
    directly) in FULL, a real machine-readable PDF, containing THREE
    directly-relevant norms read verbatim:
    1. Decreto-Ley No. 107/2025 (Consejo de Estado, dado 16 de abril de
       2025), amending Ley 113 'Del Sistema Tributario' (de 23 de julio
       de 2012) Art.388.2: 'La Administración Tributaria asigna un
       número de identificación tributaria, que será el código único
       para el control y trazabilidad de las operaciones fiscales de
       los contribuyentes'.
    2. Decreto 131/2025 (Consejo de Ministros, dado 30 de mayo de 2025),
       amending Decreto 308 'Reglamento de las Normas Generales y de los
       Procedimientos Tributarios' (de 31 de octubre de 2012) Art.28.1:
       'A los sujetos pasivos al momento de su inscripción en el
       Registro de Contribuyentes se les asigna un Número de
       Identificación Tributaria, en lo adelante NIT, el que es el
       código único de los contribuyentes.'
    3. Resolución 162/2025 de la Oficina Nacional de Administración
       Tributaria (dada 1ro de diciembre de 2025, signed Mary Blanca
       Ortega Barredo, Jefa de la ONAT), operationalizing mandatory NIT
       use: 'Los sujetos obligados a inscripción en el Registro de
       Contribuyentes, reciben el Número de Identificación Tributaria...
       asignado por la Oficina Nacional de Administración Tributaria...
       el que es el código de identificación para todas las personas
       jurídicas y naturales que desarrollen actividades dentro del
       territorio nacional.' This same Resolución's own recital cites
       'el Decreto 129 \"De la Oficina Nacional de Administración
       Tributaria\", de 8 de mayo de 2025' as granting ONAT the status
       of 'entidad nacional subordinada al Consejo de Ministros' --
       this iteration did NOT independently fetch Decreto 129's own
       primary text (only this recital's quotation of it), an honest
       gap this catalog does not paper over.
  - **This iteration specifically investigated whether Cuba has a
    dedicated public-procurement e-tendering portal or process
    (analogous to the SIGMAP/egp.gov.bt shape other siblings model) and
    found the closest real analogue is NOT an e-procurement portal at
    all.** `gacetaoficial.gob.cu`'s own curated 'Legislaciones Cubanas'
    list names 'Decreto Ley No. 304 \"De la Contratación Económica\"'
    (Economic Contracting), published in Gaceta Oficial No. 062
    Ordinaria de 27 de diciembre de 2012 alongside its Reglamento,
    Decreto No. 310/2012 -- this iteration fetched that Gaceta issue's
    own PDF directly and confirmed its title/date/issuing-body/gazette
    citation from the document's own machine-readable cover/index page
    ('Gaceta Oficial No. 062 Ordinaria de 27 de diciembre de 2012 --
    CONSEJO DE ESTADO Decreto-Ley No. 304 -- CONSEJO DE MINISTROS
    Decreto No. 310'), but the substantive ~30 pages of article text in
    that same PDF did not extract via `pdftotext` (embedded-font
    encoding this iteration's tooling could not map to readable
    characters) and this iteration did NOT attempt an OCR pass on it --
    an honest gap: this catalog names the law's EXISTENCE, title, date
    and issuing bodies (HIGH confidence, read directly) without
    asserting what its substantive articles say (not read). Regardless,
    Decreto-Ley 304 governs DOMESTIC economic contracting between
    Cuban economic actors -- it is NOT the FDI market-entry authorization
    pipeline described above, which remains Ley 118/Decreto 325's own
    MINCEX-Comisión-de-Evaluación-authority-tier route.
  - `reserved-market`-equivalent `:approval-authority` fields ground
    this vertical's FLAGSHIP check (see `marketentry.governor` /
    `marketentry.registry`) -- a genuinely Cuba-specific mechanism this
    iteration found directly in Ley 118's own Art.21, read verbatim from
    the primary PDF text: 'La aprobación para efectuar inversiones
    extranjeras en el territorio nacional se otorga atendiendo al
    sector, la modalidad y las características de la inversión
    extranjera, por los órganos del Estado siguientes: a) el Consejo de
    Estado; b) el Consejo de Ministros; y c) el jefe del organismo de la
    Administración Central del Estado autorizado para ello.' Own
    Art.21.2 assigns Consejo de Estado approval when '(a) cuando se
    exploren o exploten recursos naturales no renovables, excepto al
    amparo de contratos de asociación económica internacional a riesgo
    que se aprueban y autorizan según el apartado 3 inciso d)... y (b)
    cuando se realicen para la gestión de servicios públicos, tales
    como transporte, comunicaciones, acueductos, electricidad, la
    realización de una obra pública o la explotación de un bien de
    dominio público.' Own Art.21.3 assigns Consejo de Ministros approval
    for '(a) desarrollos inmobiliarios; (b) empresas de capital
    totalmente extranjero; (c) la transmisión de la propiedad estatal u
    otros derechos reales sobre bienes estatales; (d) los contratos de
    asociación económica internacional a riesgo para la explotación de
    recursos naturales no renovables y su producción; (e) la
    intervención de una empresa extranjera con participación de capital
    público; (f) el uso de fuentes renovables de energía; (g) el
    sistema empresarial de los sectores de la salud, la educación y de
    las instituciones armadas; y (h) otras inversiones extranjeras que
    no requieran la aprobación del Consejo de Estado.' Own Art.21.4:
    'El Consejo de Ministros puede delegar en jefes de los organismos de
    la Administración Central del Estado, la facultad de aprobar y
    autorizar inversiones extranjeras en los casos de su competencia'
    -- this THIRD tier's delegation is per-sector and DISCRETIONARY
    ('puede delegar'), and this iteration did NOT independently fetch
    the specific delegation instruments naming which organismos received
    which sectors, so `marketentry.registry`'s independent recompute
    deliberately models only the two tiers Art.21.2/21.3 state directly
    and unconditionally (Consejo de Estado / Consejo de Ministros),
    the same honest scope-narrowing discipline CAF's Marché réservé
    value-threshold delegation and Bhutan's unread Debarment Rules
    duration clause already established for this family. This is a
    genuinely different check SHAPE from every prior iso3166 sibling
    this repo mirrors (turnover formula / flat threshold / boolean
    registry membership / 3-tier value class / bid-margin recompute /
    struck-off boolean / expiry-date recompute / precedence-ordering /
    sector set-membership / ordered-tier classification / workforce-
    composition eligibility / exclusion-duration cap / threshold-band
    classification): it is an AUTHORITY-JURISDICTION ROUTING
    classification with a textual override (the Art.21.2(a) risk-EAIC
    carve-out that redirects an otherwise-Consejo-de-Estado sector to
    Consejo de Ministros), not a bidder-ELIGIBILITY test at all -- the
    check asks 'does this filing correctly identify WHICH government
    body has jurisdiction to approve it', not 'is this bidder allowed to
    compete'.
  - **Sector exclusion**: Ley 118 Art.11.1 (own text, read directly):
    'La inversión extranjera puede ser autorizada en todos los sectores,
    con excepción de los servicios de salud y educación a la población y
    de las instituciones armadas, salvo en sus sistemas empresariales.'
    This iteration deliberately did NOT build the flagship check on this
    categorical sector-exclusion (health/education services to the
    public, and the armed forces institutions outside their own
    business systems, are simply never eligible for FDI in ANY tier) --
    a boolean categorical sector-exclusion allow-list is the SAME check
    shape Bhutan's FDI Negative List already added to this family (see
    `marketentry.registry`'s docstring). It is documented here as a
    real, verified fact this catalog does not fabricate a check around.
  - Coverage is reported HONESTLY (see `coverage`): a jurisdiction not
    in this table has NO spec-basis, full stop -- the advisor must not
    fabricate one, and the governor holds if it tries.")

(def catalog
  "iso3 -> requirement map. `:required-evidence` mirrors the generic
  intake/portal-registration/filing evidence set; `:legal-basis` /
  `:owner-authority` / `:provenance` are the G2 citation the governor
  requires before any `:jurisdiction/assess` proposal can commit. CUB
  deliberately carries NO `:rep-owner-authority` -- this iteration did
  not find a verifiable Cuban analogue to CAF's/Benin's representative-
  exclusion-extension provision (a real mechanism may exist; this
  iteration simply did not locate and confirm one at a specific article
  number). `:approval-authority-owner-authority` /
  `:approval-authority-legal-basis` / `:approval-authority-criteria` /
  `:approval-authority-provenance` ground this vertical's flagship
  governor check (`investment-approval-authority`/
  `approval-authority-mismatch?` in `marketentry.registry`)."
  {"CUB" {:name "Republic of Cuba"
          :owner-authority "Ministerio del Comercio Exterior y la Inversión Extranjera (MINCEX) -- receives, admits (Decreto 325/2014 Reglamento Art.33) and refers admitted foreign-investment proposals to the Comisión de Evaluación de Negocios con Inversión Extranjera (Art.34) before presenting the evaluated file to whichever of Ley 118 Art.21's three approval authorities (Consejo de Estado / Consejo de Ministros / a delegated jefe de organismo) has jurisdiction over the proposal's sector and modality"
          :legal-basis "Ley No. 118 \"Ley de la Inversión Extranjera\" (dada 29 de marzo de 2014, publicada Gaceta Oficial No. 20 Extraordinaria, 16 de abril de 2014) and its Reglamento, Decreto No. 325/2014 (same Gaceta issue) -- Art.21.1 assigns foreign-investment approval authority across three tiers by sector/modality: Consejo de Estado (Art.21.2: non-renewable natural-resource exploration/exploitation UNLESS the modality is a risk contrato de asociación económica internacional, which Art.21.3(d) instead routes to Consejo de Ministros; and management of public services -- transport, communications, aqueducts, electricity, public works, exploitation of public-domain assets); Consejo de Ministros (Art.21.3(a)-(h): real-estate development, empresas de capital totalmente extranjero, transfer of state property/other real rights over state assets, risk EAIC contracts for non-renewable-resource exploitation, foreign entities with public-capital participation, renewable-energy use, the business system of the health/education/armed-forces sectors, and any other FDI not requiring Consejo de Estado approval); and a jefe de organismo de la Administración Central del Estado the Consejo de Ministros may discretionarily delegate to (Art.21.4, per-sector delegation instruments not independently fetched by this iteration -- see namespace docstring). Art.11.1 further excludes health/education services to the public and the armed forces institutions themselves (outside their own business systems) from FDI eligibility in any tier."
          :national-spec "No dedicated e-procurement/self-service FDI portal exists (unlike a market economy's SAM.gov/e-Vergabe/e-GP shape); Cuba's FDI market entry is an executive-branch AUTHORIZATION pipeline, not a competitive-bid/tender system. Once authorized, the empresa mixta / contrato de asociación económica internacional / empresa de capital totalmente extranjero must register in the Registro Mercantil (Ministerio de Justicia; Decreto-Ley 226/2001 Art.2.1(c)-(e)) to acquire legal personality/enter into force (Ley 118 Art.14.6/15.5/16.2). Cuba's DOMESTIC economic contracting among state enterprises runs separately under Decreto-Ley No. 304/2012 \"De la Contratación Económica\" and its Reglamento Decreto No. 310/2012 (Gaceta Oficial No. 062 Ordinaria, 27 de diciembre de 2012) -- existence/title/date/issuing-bodies confirmed directly from that gazette's own cover/index page; the substantive article text is embedded-font PDF this iteration's pdftotext pass could not extract and did not OCR (honest gap, not a claim about contents). This is NOT the FDI authorization route above."
          :provenance "https://www.gacetaoficial.gob.cu/sites/default/files/go_x_20_2014.pdf ; https://www.gacetaoficial.gob.cu/es/ley-118-de-2014-de-asamblea-nacional-del-poder-popular ; https://www.gacetaoficial.gob.cu/es/decreto-325-de-2014-de-consejo-de-ministros ; https://www.minjus.gob.cu/es/servicios/registro-mercantil ; https://www.gacetaoficial.gob.cu/sites/default/files/decreto_ley_226_del_registro_mercantil_-actualizado_20230417.pdf ; https://www.gacetaoficial.gob.cu/es/algunas-legislaciones-cubanas (Decreto Ley No. 304 citation)"
          :required-evidence ["Registro Mercantil inscription record (empresa mixta / contrato de asociación económica internacional / empresa de capital totalmente extranjero, per Decreto-Ley 226/2001 Art.2.1(c)-(e), administered by the Ministerio de Justicia -- Registro Mercantil Central + Registros Mercantiles Territoriales)"
                              "ONAT NIT (Número de Identificación Tributaria) registration record (Registro de Contribuyentes, per Decreto 308/2012 Art.28 as amended by Decreto 131/2025, operationalized by Resolución 162/2025 de la Oficina Nacional de Administración Tributaria)"
                              "MINCEX / Comisión de Evaluación de Negocios con Inversión Extranjera evaluation dictamen on file (Decreto 325/2014 Reglamento Art.34)"
                              "FDI approval-authority tier confirmation record (Ley 118 Art.21 Consejo de Estado / Consejo de Ministros authorization)"
                              "Authorized-representative confirmation record"]
          :corporate-number-owner-authority "Oficina Nacional de Administración Tributaria (ONAT) -- per Resolución 162/2025 de la ONAT's own recital, an entidad nacional subordinada al Consejo de Ministros per Decreto 129 \"De la Oficina Nacional de Administración Tributaria\", de 8 de mayo de 2025 (this iteration did not independently fetch Decreto 129's own primary text, only this recital's quotation of it)"
          :corporate-number-legal-basis "Ley 113 \"Del Sistema Tributario\" (de 23 de julio de 2012), as amended by Decreto-Ley 107/2025 (dado 16 de abril de 2025) Art.388.2 (own text, read directly): 'La Administración Tributaria asigna un número de identificación tributaria, que será el código único para el control y trazabilidad de las operaciones fiscales de los contribuyentes'; Decreto 308/2012 \"Reglamento de las Normas Generales y de los Procedimientos Tributarios\", as amended by Decreto 131/2025 (dado 30 de mayo de 2025) Art.28.1 (own text, read directly): 'A los sujetos pasivos al momento de su inscripción en el Registro de Contribuyentes se les asigna un Número de Identificación Tributaria, en lo adelante NIT'; operationalized by Resolución 162/2025 de la ONAT (dada 1ro de diciembre de 2025, Gaceta Oficial No. 97 Ordinaria de 2025, publicada 23/12/2025): 'el código de identificación para todas las personas jurídicas y naturales que desarrollen actividades dentro del territorio nacional'"
          :corporate-number-provenance "https://www.gacetaoficial.gob.cu/sites/default/files/goc-2025-o97_0.pdf ; https://www.gacetaoficial.gob.cu/es/resolucion-162-de-2025-de-oficina-nacional-de-administracion-tributaria"
          :approval-authority-owner-authority "Consejo de Estado (highest tier) / Consejo de Ministros (second tier, also the residual default) -- the Ministerio del Comercio Exterior y la Inversión Extranjera routes the evaluated proposal to whichever body Ley 118 Art.21 assigns"
          :approval-authority-legal-basis "Ley 118 \"Ley de la Inversión Extranjera\" (Gaceta Oficial No. 20 Extraordinaria, 16 de abril de 2014), Art.21.1-21.4 (own text, read directly): '[Art.21.1] La aprobación para efectuar inversiones extranjeras en el territorio nacional se otorga atendiendo al sector, la modalidad y las características de la inversión extranjera, por los órganos del Estado siguientes: a) el Consejo de Estado; b) el Consejo de Ministros; y c) el jefe del organismo de la Administración Central del Estado autorizado para ello. [Art.21.2] El Consejo de Estado aprueba la inversión extranjera... en los casos siguientes: a) cuando se exploren o exploten recursos naturales no renovables, excepto al amparo de contratos de asociación económica internacional a riesgo que se aprueban y autorizan según el apartado 3 inciso d)...; y b) cuando se realicen para la gestión de servicios públicos... [Art.21.3] El Consejo de Ministros aprueba y dicta la Autorización... cuando se trate de: a) desarrollos inmobiliarios; b) empresas de capital totalmente extranjero; c) la transmisión de la propiedad estatal...; d) los contratos de asociación económica internacional a riesgo para la explotación de recursos naturales no renovables...; e) la intervención de una empresa extranjera con participación de capital público; f) el uso de fuentes renovables de energía; g) el sistema empresarial de los sectores de la salud, la educación y de las instituciones armadas; y h) otras inversiones extranjeras que no requieran la aprobación del Consejo de Estado.'"
          :approval-authority-criteria {:consejo-de-estado-sectors #{:non-renewable-resource-exploration-exploitation :public-service-management}
                                        :consejo-de-ministros-sectors #{:real-estate-development :wholly-foreign-owned-company :state-property-transfer :risk-eaic-non-renewable-resources :foreign-entity-public-capital-participation :renewable-energy-use :health-education-armed-forces-business-system}
                                        :risk-eaic-non-renewable-resources-override :consejo-de-ministros}
          :approval-authority-provenance "https://www.gacetaoficial.gob.cu/sites/default/files/go_x_20_2014.pdf"}
   "USA" {:name "United States"
          :owner-authority "U.S. General Services Administration (GSA) / SAM.gov"
          :legal-basis "Federal Acquisition Regulation (FAR); System for Award Management"
          :national-spec "SAM.gov entity registration + NAICS self-certification"
          :provenance "https://sam.gov/"
          :required-evidence ["EIN record"
                              "SAM.gov registration record"
                              "State business registration record"
                              "Authorized-representative record"]}
   "DEU" {:name "Germany"
          :owner-authority "Beschaffungsamt des BMI / e-Vergabe platforms"
          :legal-basis "Gesetz gegen Wettbewerbsbeschränkungen (GWB) / VgV"
          :national-spec "e-Vergabe supplier registration under EU procurement directives"
          :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract"
                              "e-Vergabe registration record"
                              "USt-IdNr record"
                              "Authorized-representative record"]}})

(defn spec-basis
  "The jurisdiction's requirement map, or nil -- nil means NO spec-basis,
  and the governor must hold any proposal that tries to assess or file
  on it."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report: how many of the requested jurisdictions actually
  have a spec-basis entry. Never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-cub R0: " (count catalog)
                 " jurisdictions seeded with an official spec-basis. "
                 "This is a starting catalog for market-entry navigation, "
                 "not a survey of all ~194 jurisdictions -- extend "
                 "`marketentry.facts/catalog`, never fabricate a "
                 "jurisdiction's requirements.")})))

(defn required-evidence-satisfied?
  "Does `submitted` (a set/coll of evidence keywords or strings) satisfy
  every evidence item listed for `iso3`? Missing spec-basis -> never
  satisfied."
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3]
  (:required-evidence (spec-basis iso3) []))

(defn rep-spec-basis
  "The jurisdiction's representative-related requirement map, or nil when
  this catalog has no such regime. For CUB this is deliberately nil --
  see the `catalog` docstring's honest-scope-narrowing note (this
  iteration did not locate and confirm a Cuban representative-exclusion-
  extension provision at a specific article number)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))

(defn corporate-number-spec-basis
  "The jurisdiction's corporate-number / tax-id regime, or nil."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority
                       :corporate-number-legal-basis
                       :corporate-number-provenance]))))

(defn approval-authority-spec-basis
  "The jurisdiction's FDI approval-authority-tier regime, or nil. For CUB
  this is real and current -- the flagship check this vertical adds is
  grounded here (Ley 118 Art.21, Consejo de Estado / Consejo de
  Ministros / delegated jefe de organismo)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:approval-authority-owner-authority sb)
      (select-keys sb [:approval-authority-owner-authority
                       :approval-authority-legal-basis
                       :approval-authority-criteria
                       :approval-authority-provenance]))))
