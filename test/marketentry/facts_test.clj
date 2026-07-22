(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest cub-has-spec-basis
  (let [sb (facts/spec-basis "CUB")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/corporate-number-spec-basis "CUB")))
    (is (some? (facts/approval-authority-spec-basis "CUB")))))

(deftest cub-rep-spec-basis-is-honestly-absent
  (testing "no verifiable Cuban representative-exclusion-extension provision was located -- deliberately not claimed"
    (is (nil? (facts/rep-spec-basis "CUB")))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "CUB")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "CUB" all)))
    (is (not (facts/required-evidence-satisfied? "CUB" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["CUB" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 2 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))

(deftest approval-authority-spec-basis-criteria
  (let [aa (facts/approval-authority-spec-basis "CUB")]
    (is (contains? (get-in aa [:approval-authority-criteria :consejo-de-estado-sectors])
                   :non-renewable-resource-exploration-exploitation))
    (is (contains? (get-in aa [:approval-authority-criteria :consejo-de-estado-sectors])
                   :public-service-management))
    (is (contains? (get-in aa [:approval-authority-criteria :consejo-de-ministros-sectors])
                   :wholly-foreign-owned-company))
    (is (= :consejo-de-ministros
           (get-in aa [:approval-authority-criteria :risk-eaic-non-renewable-resources-override])))))
