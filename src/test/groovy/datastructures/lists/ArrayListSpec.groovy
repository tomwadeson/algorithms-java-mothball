package datastructures.lists

import datastructures.lists.ArrayList;
import spock.lang.*

class ArrayListSpec extends Specification {

    void "should initialise an empty array list"() {
        given:
        def array = new ArrayList(10)

        expect:
        array.size() == 0
    }

    void "size of the array list should increase by 1 as items are added"() {
        given:
        def array = new ArrayList(10)

        when:
        assert array.size() == 0
        array.add("Item")

        then:
        array.size() == 1
    }

    void "size of the array list should decrease by 1 as items are deleted"() {
        given:
        def array = new ArrayList(10)

        array.add("Item1")
        array.add("Item2")
        array.add("Item3")

        when:
        assert array.size() == 3
        array.delete(0)

        then:
        array.size() == 2
    }

    @Unroll
    void "items should be removed from the array when deleted"() {
        when:
        def array = new ArrayList(5)
        (1..5).each { array.add(it) }
        array.delete(index)

        then:
        array.arr == expected

        where:
        index || expected
        0     || [2, 3, 4, 5, null]
        1     || [1, 3, 4, 5, null]
        2     || [1, 2, 4, 5, null]
        3     || [1, 2, 3, 5, null]
        4     || [1, 2, 3, 4, null]}

    void "getting an element out of the bounds of the initialised array list will throw an exception"() {
        given:
        def array = new ArrayList(5)

        when:
        array.get(5)

        then:
        thrown(IndexOutOfBoundsException)
    }
}
