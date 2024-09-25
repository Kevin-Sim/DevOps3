# DevOps3

change action to package

changed maven and actions to java 17

added code to create file in folder output with name report1.txt

```java
		new File("./output/").mkdir();
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File("./output/report1.txt")));
		writer.write("Hello World");
		writer.close();
```

copy from container back to local file system

```dockerfile
docker cp <container id>:/tmp/output/ ./output
```


![workflow](https://github.com/Kevin-Sim/DevOps3/actions/workflows/main.yml/badge.svg)

![GitHub License](https://img.shields.io/github/license/Kevin-Sim/DevOps3)

