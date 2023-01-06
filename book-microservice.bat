cd .\build\install\book-microservice

start java -Dserver.port=7006 -classpath lib/* com.distribuida.Server

start java -Dserver.port=7007 -classpath lib/* com.distribuida.Server

start java -Dserver.port=7008 -classpath lib/* com.distribuida.Server

start java -Dserver.port=7009 -classpath lib/* com.distribuida.Server