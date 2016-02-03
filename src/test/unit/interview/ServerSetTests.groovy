package interview

import spock.lang.Specification


public class ServerSetTests extends Specification {

    def 'A server can be removed after adding'(){
        setup:
        ServerElement server = new ServerElement()
        ServerSet set = new ServerSet()

        when:
        set.add(server)

        then:
        set.remove(server)
    }

    def 'When No Servers added throws NotFoundException'() {
        setup:
        ServerSet set = new ServerSet()

        when:
        set.getRandomElement()

        then:
        throw(RuntimeException.class);
    }

    def 'Random returns server with least load'() {
    }

    def 'Removing server that does not exist throw exception'(){
    }
}