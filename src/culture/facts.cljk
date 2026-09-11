(ns culture.facts
  "Country-level regional-culture catalog for Cuba (CUB) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). First facts namespace
  in this blueprint-stage repo; the marketentry/statute catalogs land with
  :implemented (ADR-2607141700). City-level counterparts live in the
  cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors the fleet's `statute.facts`
  convention); entries carry no :culture/municipality (that attribute is
  city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"CUB"
   [{:culture/id "cub.dish.ropa-vieja"
     :culture/name "Ropa vieja"
     :culture/country "CUB"
     :culture/kind :dish
     :culture/summary "Stewed beef and tomatoes on a sofrito base, one of the national dishes of Cuba; believed brought by Canary Islands immigrants and first reported cooked in Cuba in 1857."
     :culture/url "https://en.wikipedia.org/wiki/Ropa_vieja"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "cub.dish.moros-y-cristianos"
     :culture/name "Moros y Cristianos"
     :culture/country "CUB"
     :culture/kind :dish
     :culture/summary "Cuban dish of black beans and white rice cooked together in one pot, served in homes and restaurants."
     :culture/url "https://en.wikipedia.org/wiki/Moros_y_Cristianos_(food)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "cub.dish.picadillo"
     :culture/name "Picadillo"
     :culture/country "CUB"
     :culture/kind :dish
     :culture/summary "Ground-beef dish traditional in many Latin American countries including Cuba; the Cuban version includes tomato sauce, olives and capers and is served over white rice."
     :culture/url "https://en.wikipedia.org/wiki/Picadillo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "cub.beverage.mojito"
     :culture/name "Mojito"
     :culture/country "CUB"
     :culture/kind :beverage
     :culture/summary "Traditional Cuban punch cocktail of white rum, lime juice, sugar, soda water and mint; Havana is its birthplace, although the exact origin is debated."
     :culture/url "https://en.wikipedia.org/wiki/Mojito"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "cub.product.cuban-cigar"
     :culture/name "Cuban cigar"
     :culture/name-local "Habano"
     :culture/country "CUB"
     :culture/kind :product
     :culture/summary "Cuba is central to cigar history: cigar smoking was first observed by Europeans among the Taíno of Cuba in 1492, the Spanish established the first cigar factory in Cuba in 1542, and premium cigar making remains rooted in the historic Cuban cigar industry."
     :culture/url "https://en.wikipedia.org/wiki/Cigar"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "cub.festival.carnival-of-santiago-de-cuba"
     :culture/name "Carnival of Santiago de Cuba"
     :culture/name-local "Carnaval de Santiago de Cuba"
     :culture/country "CUB"
     :culture/kind :festival
     :culture/summary "Carnival celebration in Santiago de Cuba that enjoys a special status among Cubans, with large public celebrations in the city dating back to at least the 17th century."
     :culture/url "https://en.wikipedia.org/wiki/Carnival_of_Santiago_de_Cuba"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "cub.heritage.old-havana"
     :culture/name "Old Havana"
     :culture/name-local "La Habana Vieja"
     :culture/country "CUB"
     :culture/kind :heritage
     :culture/summary "Historic city centre of Havana, inscribed on the UNESCO World Heritage List in 1982 for its unique Baroque and neoclassical architecture and its fortifications."
     :culture/url "https://en.wikipedia.org/wiki/Old_Havana"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-cub culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "CUB"))
                 " CUB entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
