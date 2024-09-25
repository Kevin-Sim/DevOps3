# DevOps3

Cut down version of First Three Labs for SET09623/09823

![workflow](https://github.com/Kevin-Sim/DevOps3/actions/workflows/main.yml/badge.svg)

![GitHub License](https://img.shields.io/github/license/Kevin-Sim/DevOps3)

Could also add the following to actions to copy back to a new branch
Need to give read write permissions in GitHub settings
```yaml
      - name: Copy Output
        run: docker container cp devops3-app-1:./tmp/output ./
      - name: Deploy
        uses: JamesIves/github-pages-deploy-action@v4.2.5
        with:
          branch: output # The branch the action should deploy to.
          folder: output # The folder we are copying
```
