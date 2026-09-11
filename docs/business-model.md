# Business Model — Republic of Cuba

## Offer

- MINCEX (Ministerio del Comercio Exterior y la Inversión Extranjera)
  foreign-investment authorization -- Ley No. 118 "Ley de la Inversión
  Extranjera" (Gaceta Oficial No. 20 Extraordinaria, 16 de abril de
  2014) and its Reglamento (Decreto 325/2014). No self-service
  e-procurement portal; MINCEX admits proposals, refers them to the
  Comisión de Evaluación de Negocios con Inversión Extranjera, then
  routes the file to whichever of THREE real approval authorities
  Art. 21 assigns by sector/modality (Consejo de Estado / Consejo de
  Ministros / a delegated jefe de organismo) -- a case-by-case
  AUTHORIZATION pipeline, not a competitive-tender procurement portal
  (see `src/marketentry/facts.cljk`)
- Registro Mercantil (Ministerio de Justicia, Decreto-Ley No. 226/2001)
  business registration -- required for the empresa mixta / contrato de
  asociación económica internacional / empresa de capital totalmente
  extranjero to acquire legal personality (Ley 118 Art. 14.6/15.5/16.2)
- Oficina Nacional de Administración Tributaria (ONAT) NIT (Número de
  Identificación Tributaria) tax registration (Decreto 308/2012 as
  amended by Decreto 131/2025, operationalized by Resolución 162/2025
  de la ONAT)
- Approval-authority-tier gate (flagship check) -- bars a filing that
  claims the wrong government approval authority (Consejo de Estado vs.
  Consejo de Ministros) for its own declared FDI sector/modality under
  Ley 118 Art. 21
- state-mediated market entry; foreign operators typically via an
  empresa mixta with a Cuban state-enterprise partner or a wholly-
  foreign-owned-company authorization, not direct competitive bidding

## Trust Controls

- Any actual MINCEX filing or Registro Mercantil inscription requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off.
- A false or fabricated regulatory-requirement claim is a HARD hold.
- `:filing/submit` never automated
