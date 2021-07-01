package Vcsproblem.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Vcsproblem_HttpsGithubComAChubatovaComposite : GitVcsRoot({
    uuid = "71eea1bf-475c-431c-9000-25aaf952bb55"
    name = "https://github.com/AChubatova/compositek"
    url = "https://github.com/AChubatova/composite"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:07945551-f45d-4fb3-8777-203590e119f8"
    }
})
