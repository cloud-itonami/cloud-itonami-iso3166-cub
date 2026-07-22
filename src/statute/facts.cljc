(ns statute.facts
  "General-law compliance catalog for the Republic of Cuba (CUB) --
  extends this repo's existing `marketentry.facts` (public-sector
  market-entry/foreign-investment only, narrow scope) with a second,
  orthogonal catalog of national statutes a foreign investor operating
  in this jurisdiction must generally track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-deu/-bgr/-aze/-alb/-arm/-atg/-ben/-btn/-caf's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-
  federation).

  Every entry cites an OFFICIAL government-hosted URL -- never
  fabricated. All three entries below were fetched directly
  (curl/pdftotext-verified 2026-07-22) from `gacetaoficial.gob.cu`, the
  Gaceta Oficial de la República de Cuba's own site -- its own homepage
  (fetched directly) states its constitutional/legal basis verbatim:
  'La Gaceta Oficial de la República de Cuba es la encargada de la
  publicidad normativa a tenor de lo dispuesto en el artículo 165,
  sección segunda, Capítulo VIII, Título VI, de la Constitución de la
  República, proclamada el 10 de abril de 2019. El Acuerdo No. 8663 de
  13 de agosto de 2019 del Consejo de Ministros, dispone como función
  específica del Ministerio de Justicia \"Asegurar y controlar el
  proceso de publicación en la Gaceta Oficial de la República y el
  acceso del ciudadano a la ley\".'

  - **Foreign Investment Law**: Ley No. 118 \"Ley de la Inversión
    Extranjera\", dada 29 de marzo de 2014, publicada Gaceta Oficial No.
    20 Extraordinaria, 16 de abril de 2014 -- this is the SAME law
    `marketentry.facts` uses as its market-entry spec-basis; it is
    ALSO catalogued here as a general national-law reference per this
    task's own instructions, since a foreign investor tracks it both as
    a market-entry gate and as an ongoing compliance statute (tax
    benefits/exemptions, labor adaptations, banking regime, etc. all
    live inside this one law's own later chapters).
  - **Business/company registration**: this iteration specifically
    investigated, rather than assumed by analogy to prior OHADA-member
    siblings (Benin/CAF), what Cuba's business-registration mechanism
    actually is. Cuba is NOT an OHADA member state and has no equivalent
    supranational company-law instrument; instead, business-entity
    registration runs through a purely DOMESTIC instrument, Decreto-Ley
    No. 226 \"Del Registro Mercantil\", dada 6 de diciembre de 2001
    (Consejo de Estado, signed Fidel Castro Ruz), publicada Gaceta
    Oficial Ordinaria No. 2, 10 de enero de 2002 -- this iteration
    fetched this decree's own consolidated/updated text directly
    ('ACTUALIZADO 17 DE ABRIL DE 2023') and confirmed Art.1.1 verbatim:
    'El Registro Mercantil está a cargo del Ministerio de Justicia y se
    integra por el Registro Mercantil Central y los Registros
    Mercantiles Territoriales.' Art.2.1 (as modified) lists the
    registrable subjects, including '(c) las empresas mixtas... (d) los
    contratos de Asociación Económica Internacional; (e) las empresas
    de capital totalmente extranjero...' -- an exact cross-match with
    Ley 118's own Art.14.6/15.5/16.2 registration requirement, confirmed
    independently in both primary texts. NOTE: `minjus.gob.cu`'s own
    secondary summary page for this service states an internally-
    inconsistent pairing of dates ('6 de enero del año 2001' /
    '10 de enero de 2002'); this catalog trusts the PRIMARY decree
    text's own unambiguous 'de 6 de diciembre de 2001' over the
    ministry's own secondary summary, and flags the inconsistency here
    rather than silently picking one without comment. This iteration
    also confirmed, on the SAME `minjus.gob.cu` page, that Cuba's
    domestic 1886 Código de Comercio ('hecho extensivo a Cuba por Real
    Decreto de 28 de enero de 1886, vigente en Cuba desde el 11 de mayo
    de 1886') is still named as part of the legal framework of
    commercial-registry activity, but did NOT independently fetch that
    1886 code's own primary text this iteration -- it is mentioned here
    for completeness, not catalogued as a separate `catalog` entry.
  - **Código de Trabajo (Labour Code)**: this iteration specifically
    searched for and DID independently verify Cuba's own Labour Code
    text (unlike CAF's/several siblings' honestly-reported failure to
    do so) -- Ley No. 116 \"Código de Trabajo\", dada en la Sala de
    Sesiones de la Asamblea Nacional del Poder Popular a los 20 días del
    mes de diciembre de 2013 (own closing signature, read directly:
    'Dada en la Sala de Sesiones de la Asamblea Nacional del Poder
    Popular, Palacio de las Convenciones en La Habana, a los 20 días del
    mes de diciembre de 2013.'). This iteration fetched the Gaceta
    Oficial's own consolidated/updated text ('ACTUALIZADO: 20 de febrero
    de 2020') directly and read it via `pdftotext -layout` (a real
    machine-readable PDF, not scanned). NOTE: that SAME updated PDF's
    own header states 'La presente es la versión actualizada de la Ley
    No. 116, Código de Trabajo, de 20 de diciembre de 2013, publicada en
    la Edición de la Gaceta Oficial Extraordinaria No. 29, de 17 de
    junio de 2013' -- a publication date (17 June 2013) that PRECEDES
    the law's own approval/dada date (20 December 2013) stated in the
    same document. This is an apparent internal inconsistency in the
    Gaceta's own consolidated-text header that this iteration could not
    resolve (and does not silently paper over): the law's OWN dada date
    (20 December 2013, HIGH confidence, read directly from the closing
    signature) is what this catalog cites as `:statute/enacted-date`;
    the header's 'Gaceta Oficial Extraordinaria No. 29, de 17 de junio
    de 2013' publication citation is reported as-is but flagged here as
    unresolved. Article 8 of this Código (own text, read directly)
    explicitly cross-references Ley 118: 'En las modalidades de la
    inversión extranjera, sucursales y agentes de sociedades mercantiles
    extranjeras radicadas en Cuba se cumple en materia de trabajo, lo
    establecido en este Código y su legislación complementaria, con las
    adecuaciones que establezca la Ley de la Inversión Extranjera' --
    independently corroborating Ley 118's own Art.27's identical
    cross-reference in the other direction.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"CUB"
   [{:statute/id "cub.ley-118-inversion-extranjera"
     :statute/title "Ley No. 118 \"Ley de la Inversión Extranjera\""
     :statute/jurisdiction "CUB"
     :statute/kind :law
     :statute/law-number "Ley No. 118, dada 29 de marzo de 2014 (Asamblea Nacional del Poder Popular), publicada Gaceta Oficial No. 20 Extraordinaria, 16 de abril de 2014 (own masthead read directly; the Gaceta site's own node metadata field states a conflicting 'Fecha: 16/05/2014' this catalog does not trust over the primary document's own repeated in-body dating)"
     :statute/url "https://www.gacetaoficial.gob.cu/sites/default/files/go_x_20_2014.pdf"
     :statute/url-provenance :official-gaceta-oficial-gob-cu
     :statute/enacted-date "2014-03-29"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:foreign-investment :corporate-governance :incorporation :tax :labor}}
    {:statute/id "cub.decreto-ley-226-registro-mercantil"
     :statute/title "Decreto-Ley No. 226 \"Del Registro Mercantil\""
     :statute/jurisdiction "CUB"
     :statute/kind :decree-law
     :statute/law-number "Decreto-Ley No. 226, dada 6 de diciembre de 2001 (Consejo de Estado, signed Fidel Castro Ruz), publicada Gaceta Oficial Ordinaria No. 2, 10 de enero de 2002; modified by Decreto-Ley 26/2020 (Gaceta Oficial Ordinaria No. 63, 7 de junio de 2021) -- this iteration's own directly-fetched consolidated text is dated 'ACTUALIZADO 17 DE ABRIL DE 2023'. minjus.gob.cu's own secondary summary page states an internally-inconsistent '6 de enero del año 2001' pairing this catalog does not adopt (see namespace docstring)"
     :statute/url "https://www.gacetaoficial.gob.cu/sites/default/files/decreto_ley_226_del_registro_mercantil_-actualizado_20230417.pdf"
     :statute/url-provenance :official-gaceta-oficial-gob-cu
     :statute/enacted-date "2001-12-06"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "cub.ley-116-codigo-trabajo"
     :statute/title "Ley No. 116 \"Código de Trabajo\""
     :statute/jurisdiction "CUB"
     :statute/kind :law
     :statute/law-number "Ley No. 116, dada 20 de diciembre de 2013 (Asamblea Nacional del Poder Popular, own closing signature read directly), versión actualizada 20 de febrero de 2020 -- the SAME consolidated PDF's own header cites a publication edition ('Gaceta Oficial Extraordinaria No. 29, de 17 de junio de 2013') that precedes the law's own dada date, an unresolved internal inconsistency this catalog flags rather than silently resolves (see namespace docstring)"
     :statute/url "https://www.gacetaoficial.gob.cu/sites/default/files/codigotrabajoactualizado_20022020.pdf"
     :statute/url-provenance :official-gaceta-oficial-gob-cu
     :statute/enacted-date "2013-12-20"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:labor}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-cub statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "CUB")) " CUB statute(s) seeded with an "
                 "official citation. Extend `statute.facts/catalog`, never "
                 "fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :data-protection)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
