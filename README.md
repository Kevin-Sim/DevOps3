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

and do the same in actions and copy to new branch

```yml
      - name: Copy Output
        run: docker container cp sem_employees_app_1:./tmp/output ./
      - name: Deploy
        uses: JamesIves/github-pages-deploy-action@v4.2.5
        with:
          branch: output # The branch the action should deploy to.
          folder: output # The folder we are copying
```

We need to give actions permissions.

From the repository select settings then on the left actions and general. Scroll down and select grant read / write permissions

![workflow](https://github.com/Kevin-Sim/DevOps3/actions/workflows/main.yml/badge.svg)

![GitHub License](https://img.shields.io/github/license/Kevin-Sim/DevOps3)

