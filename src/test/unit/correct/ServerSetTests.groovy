package correct

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
        ServerSet set = new ServerSet();

        when:
        set.getRandomElement()

        then:
        thrown(RuntimeException)
    }

    def 'getRandom works when 3 servers'() {
        setup:
        ServerSet set = new ServerSet();
        and:
        set.add(new ServerElement(name:'Server 1'))
        set.add(new ServerElement(name:'Server 2'))
        set.add(new ServerElement(name:'Server 3'))
        Set<String> results = new HashSet<>()

        when:
        ServerElement result = set.getRandomElement();

        then:
        result != null
        result.getName().contains('Server')
        println result.name
        and:
        (1..10).each{
            ServerElement server =set.getRandomElement()
            println server.name
            results.add(server.name)
        }
        results.size() == 3
    }

    def 'Removing non-existent server throws exception'(){
        given:
        ServerSet set = new ServerSet();
        ServerElement server = new ServerElement(name:'Server 1')

        when:
        set.remove(server);

        then:
        thrown(RuntimeException)
    }

    def 'Adding null server throws exception'(){
        given:
        ServerSet set = new ServerSet();

        when:
        set.add(null);

        then:
        thrown(RuntimeException)
    }

    def 'Removing null server throws exception'(){
        given:
        ServerSet set = new ServerSet();

        when:
        set.remove(null);

        then:
        thrown(RuntimeException)
    }
}