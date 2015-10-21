package datastructures.graphs

import datastructures.graphs.Edge
import spock.lang.*

class EdgeSpec extends Specification {

    void "an Edge should transform to a size-2 list"() {
        given:
        def edge = new Edge(1, 2)

        expect:
        edge.toList() == [1, 2]
    }
}