(ns marketentry.registry-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.registry :as registry]))

(deftest engagement-fee-recompute
  (let [e {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 860000.0}]
    (is (== 860000.0 (registry/compute-engagement-fee e)))
    (is (true? (registry/engagement-fee-matches-claim? e))))
  (let [bad {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 999000.0}]
    (is (false? (registry/engagement-fee-matches-claim? bad)))))

(deftest register-draft-and-submit
  (let [d (registry/register-draft "eng-1" "CUB" 0)
        s (registry/register-submit "eng-1" "CUB" 0)]
    (is (= "CUB-DFT-000000" (get d "draft_number")))
    (is (= "CUB-SUB-000000" (get s "submit_number")))
    (is (nil? (get-in d ["certificate" "proof"])))
    (is (= "draft-unsigned" (get-in s ["certificate" "status"])))))

(deftest register-requires-ids
  (is (thrown? Exception (registry/register-draft "" "CUB" 0)))
  (is (thrown? Exception (registry/register-submit "eng-1" "" 0))))

(deftest approval-authority-consejo-de-estado-sectors
  (testing "non-renewable-resource exploration/exploitation routes to Consejo de Estado by default"
    (is (= :consejo-de-estado
           (registry/investment-approval-authority
            {:fdi-sector :non-renewable-resource-exploration-exploitation}))))
  (testing "public-service management routes to Consejo de Estado"
    (is (= :consejo-de-estado
           (registry/investment-approval-authority
            {:fdi-sector :public-service-management})))))

(deftest approval-authority-risk-eaic-override
  (testing "a risk EAIC contract for non-renewable resources is Art.21.2(a)'s own exception -- Consejo de Ministros, NOT Consejo de Estado"
    (is (= :consejo-de-ministros
           (registry/investment-approval-authority
            {:fdi-sector :non-renewable-resource-exploration-exploitation
             :fdi-modality :risk-international-economic-association-contract})))))

(deftest approval-authority-consejo-de-ministros-sectors-and-residual
  (testing "Art.21.3(a)-(g) named sectors route to Consejo de Ministros"
    (is (= :consejo-de-ministros (registry/investment-approval-authority {:fdi-sector :wholly-foreign-owned-company})))
    (is (= :consejo-de-ministros (registry/investment-approval-authority {:fdi-sector :real-estate-development}))))
  (testing "the residual bucket (Art.21.3(h)) is the classification's own default"
    (is (= :consejo-de-ministros (registry/investment-approval-authority {:fdi-sector :manufacturing})))
    (is (= :consejo-de-ministros (registry/investment-approval-authority {})))))

(deftest approval-authority-mismatch-claim-is-entity-scope-gated
  (testing "an engagement with no claimed authority at all is never flagged"
    (is (false? (registry/approval-authority-mismatch? {:fdi-sector :non-renewable-resource-exploration-exploitation}))))
  (testing "a claimed authority that does NOT match the independently recomputed tier -> mismatch"
    (is (true? (registry/approval-authority-mismatch?
                {:fdi-sector :non-renewable-resource-exploration-exploitation
                 :fdi-modality :direct
                 :claimed-approval-authority :consejo-de-ministros}))))
  (testing "a claimed authority that DOES match -> not flagged"
    (is (false? (registry/approval-authority-mismatch?
                 {:fdi-sector :non-renewable-resource-exploration-exploitation
                  :fdi-modality :direct
                  :claimed-approval-authority :consejo-de-estado})))
    (is (false? (registry/approval-authority-mismatch?
                 {:fdi-sector :manufacturing
                  :claimed-approval-authority :consejo-de-ministros})))))

;; ---------------------------------------------------------------------------
;; Money is compared at money precision, not at double precision
;; ---------------------------------------------------------------------------

(deftest whole-unit-fees-were-already-correct-and-stay-correct
  (testing "the seeded shape: base + rate x months in whole currency units"
    (is (registry/engagement-fee-matches-claim?
         {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12
           :claimed-fee 860000.0}))))

(deftest cent-denominated-fees-are-no-longer-rejected-while-correct
  (testing "`(== (double claimed) (+ (double base) (* (double rate) (double months))))`
            rejected CORRECT totals once an amount carried cents -- 40,989 of
            327,060 combinations (12.5%), against 0 of 327,060 in whole units"
    (let [bad (for [m (range 1 37)
                    bc (range 10000 90000 2100)
                    rc (range 500 6000 210)
                    :let [truth (/ (+ bc (* rc m)) 100.0)]
                    :when (not (registry/engagement-fee-matches-claim?
                                {:base-fee (/ bc 100.0) :monthly-rate (/ rc 100.0)
                                  :monitoring-months m :claimed-fee truth}))]
                [m (/ bc 100.0) (/ rc 100.0) truth])]
      (is (empty? bad) (str "false rejections: " (count bad) " e.g. " (first bad))))))

(deftest a-genuinely-wrong-fee-is-still-caught
  (testing "rounding to money precision must not blunt the check"
    (is (not (registry/engagement-fee-matches-claim?
              {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12
                :claimed-fee 860000.01})))
    (is (not (registry/engagement-fee-matches-claim?
              {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12
                :claimed-fee 859999.99})))))

(deftest an-unverifiable-fee-never-matches
  (testing "un-verifiable is not the same as correct, and not a crash"
    (is (not (registry/engagement-fee-matches-claim?
              {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12})))
    (is (not (registry/engagement-fee-matches-claim?
              {:base-fee "500000" :monthly-rate 30000 :monitoring-months 12
                :claimed-fee 860000.0})))
    (is (nil? (registry/compute-engagement-fee {:base-fee 500000 :monthly-rate 30000})))))
