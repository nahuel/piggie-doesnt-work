(defproject piggie-doesnt-work "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]


                 [com.cemerick/piggieback "0.0.2"]
                 ;; [clojure-complete "0.2.2" :exclusions [org.clojure/clojure]]
                 ]

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                 :port 5050}

  :main piggie-doesnt-work.core
  )
