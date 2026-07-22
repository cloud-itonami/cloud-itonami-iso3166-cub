# cloud-itonami-iso3166-cub

Open ISO 3166 Blueprint for **CUB**: Republic of Cuba.

- MINCEX (Ministerio del Comercio Exterior y la Inversión Extranjera)
  foreign-investment authorization -- Ley No. 118 "Ley de la Inversión
  Extranjera" (16 de abril de 2014), a case-by-case AUTHORIZATION
  pipeline (Consejo de Estado / Consejo de Ministros / delegated jefe
  de organismo, per Art. 21), not a competitive-tender e-procurement
  portal
- Registro Mercantil (Ministerio de Justicia, Decreto-Ley 226/2001)
  business registration + ONAT (Oficina Nacional de Administración
  Tributaria) NIT tax registration for foreign-investment vehicles

AGPL-3.0-or-later.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture
as `cloud-itonami-iso3166-btn`/`-bwa`/`-caf`, adapted to Cuba's genuinely
different centrally-planned-economy market-entry surface (verified
2026-07-22, see the namespace docstrings for the full research trail,
including facts this iteration could NOT verify, such as a Decreto-Ley
304/2012 "De la Contratación Económica" full-text read -- the PDF's
substantive pages did not extract via `pdftotext` and were not OCR'd):

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites Ley No. 118
  "Ley de la Inversión Extranjera" (Gaceta Oficial No. 20 Extraordinaria,
  16 de abril de 2014) and its Reglamento (Decreto 325/2014): MINCEX
  admits proposals, refers them to the Comisión de Evaluación de
  Negocios con Inversión Extranjera, then routes the file to whichever
  of THREE real approval authorities Art. 21 assigns by sector/modality
  (Consejo de Estado / Consejo de Ministros / a delegated jefe de
  organismo); Registro Mercantil (Decreto-Ley 226/2001, Ministerio de
  Justicia) business registration; ONAT NIT (Número de Identificación
  Tributaria) tax registration (Decreto 308/2012 as amended by Decreto
  131/2025, operationalized by Resolución 162/2025 de la ONAT).
  `governor.cljc`'s flagship check independently recomputes WHICH of
  the two directly-verifiable approval-authority tiers (Consejo de
  Estado / Consejo de Ministros) Ley 118 Art. 21's own sector/modality
  rules assign to a filing, including the Art. 21.2(a) risk-EAIC
  override -- an AUTHORITY-JURISDICTION ROUTING check, a shape
  genuinely different from every other iso3166 sibling's (none of which
  check WHICH GOVERNMENT BODY has jurisdiction, only whether a
  bidder/investor is eligible).
- `src/statute/facts.cljc` -- general-law catalog: Ley No. 118 itself
  (also catalogued here as an ongoing compliance statute, not just a
  market-entry gate), Decreto-Ley No. 226 "Del Registro Mercantil"
  (2001, business registration), and Ley No. 116 "Código de Trabajo"
  (Labour Code, 2013, updated 2020) -- this iteration DID independently
  verify Cuba's Labour Code text (Article 8 cross-references Ley 118),
  unlike several siblings' honestly-reported inability to do so for
  their own jurisdiction.

Every citation is curl/pdftotext-verified against an official source
(`gacetaoficial.gob.cu`, `minjus.gob.cu`); two internal date
inconsistencies found in the source material itself (the Gaceta site's
own secondary node-metadata field for Ley 118, and the Gaceta's own
consolidated Código de Trabajo PDF header) are flagged explicitly in
the namespace docstrings rather than silently resolved.

## Culture catalog

This repo carries a **country-level regional-culture catalog**
(ADR-2607171400 addendum 2, `cloud-itonami-municipality-culture-catalog`
Wave 1, in `com-junkawasaki/root`) — national dishes, protected products,
beverages, crafts, festivals and heritage sites for Cuba:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring the fleet's `statute.facts` convention).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
