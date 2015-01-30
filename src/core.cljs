(ns excel.core
  (:require [om-bootstrap.table :refer [table]]
            [om-bootstrap.button :as b]
            [om-bootstrap.panel :as p]
            [om-bootstrap.nav :as n]
            [om.core :as om :include-macros true]
            [om.dom :as d :include-macros true]))

(def app-state
  (atom
    {:tab [
              ["" "" "" "" ""]
              ["" "" "" "" ""]
              ["" "" "" "" ""]
              ["" "" "" "" ""]
              ["" "" "" "" ""]
             ]}))

(defn tableau [data owner]
  (reify
    om/IRender
    (render [this]
  (p/panel (merge {:header (dom/h3 "Panel title")}
                  (when style {:bs-style style}))
           "Panel content")
)))

(defn tab-view [app owner]
  (reify
    om/IRender
    (render [_]
     (table {:striped? true :bordered? true :condensed? true :hover? true}
             (d/thead "thead"
              (apply d/tr "trhead"
               (d/td "th0" "#")
               (map-indexed (fn [n item]
                              (let [col (+ 1 n)]
                              (d/th (str "th" col) col))) (first (:tab app)))))
              (apply d/tbody "tbody"
               (map-indexed (fn [n r]
                (let [row (+ 1 n)]
                (apply d/tr (str "tr" n)
                 (d/td (str row "0") row)
                 (map-indexed (fn [n2 c] (d/td (str "td" row) c)) r)))) (:tab app)))))))

(om/root tab-view app-state
  {:target (. js/document (getElementById "tab"))})
