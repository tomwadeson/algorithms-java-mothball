package datastructures.lists

import datastructures.lists.LinkedList;
import spock.lang.*

class LinkedListSpec extends Specification {

    void "should initialise an empty list"() {
        given:
        def list = new LinkedList()

        expect:
        list.size() == 0
    }

    void "an item added to an empty list should result in a singleton list"() {
        given:
        def list = new LinkedList()

        when:
        list.add("Item")

        then:
        list.size()
    }

    @Unroll
    void "should be able to get items added to a list by their indices"() {
        given:
        def list = new LinkedList()
        (1..5).each { list.add(it) }

        when:
        def item = list.get(index)

        then:
        item == expected

        where:
        index || expected
        0     || 1
        1     || 2
        2     || 3
        3     || 4
        4     || 5
    }

    void "getting elements outside of the list's bounds will throw an exception"() {
        given:
        def list = new LinkedList()

        when:
        list.get(0)

        then:
        thrown(IndexOutOfBoundsException)
    }

    @Unroll
    void "should be able to delete items from the list"() {
        given:
        def list = new LinkedList()
        (1..5).each { list.add(it) }

        when:
        list.delete(index)

        then:
        toList(list) == expected

        where:
        index || expected
        0     || [2, 3, 4, 5]
        1     || [1, 3, 4, 5]
        2     || [1, 2, 4, 5]
        3     || [1, 2, 3, 5]
        4     || [1, 2, 3, 4]
    }

    def toList(LinkedList l) {
        def list = []
        for (int i = 0; i < l.size(); i++)
            list.add(l.get(i))
        list
    }
}