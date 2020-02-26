DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

if [ "$1" == "dev" ]; then
    mvn -Pdevelopment clean package    
elif [ "$1" == "prod" ]; then
    mvn -Pproduction clean package
elif [ "$1" == "help" ]; then
	echo -e "dev - run with sqlite attached\nprod - run with psql attached\nclean - clean mvn directories\nhelp - for help\n"
elif [ "$1" == "clean" ]; then
	rm -rf $DIR/.mvn
    rm -rf $DIR/target
    rm -rf $DIR/.classpath
    rm -rf $DIR/.factorypath
    rm -rf $DIR/.project
    rm -rf $DIR/mvnw
    rm -rf $DIR/mvnw.cmd
elif [ "$1" == "jar" ]; then
    java -jar target/fhub-0.0.1-SNAPSHOT.jar
else
    echo "type help for help"
fi
