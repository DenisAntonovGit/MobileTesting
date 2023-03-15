# Проект по автоматизации тестирования для мобильного приложения Wikipedia
<a target="_blank" href="https://www.wikipedia.org/">Веб-сайт Wikipedia</a>

## :scroll: Содержание:

* <a href="#stack">Используемые технологии</a>
* <a href="#verifications">Реализованные проверки</a>
* <a href="#jenkins-build">Параметры сборки в Jenkins</a>
* <a href="#terminal-run">Запуск тестов из терминала</a>
* <a href="#allure-report">Allure отчет</a>
* <a href="#allure-TestOps">Интеграция с Allure TestOps</a>
* <a href="#telegram-notification">Отчет в Telegram</a>
* <a href="#browserstack-video">Видео с примером прохождения тестов</a>

<a id="stack"></a>
## 🔧 Используемые технологии:

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="Media/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="Media/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="Media/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="Media/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="Media/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="Media/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="Media/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="Media/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://qameta.io/"><img src="Media/allureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.java.com"><img src="Media/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://rest-assured.io/"><img src="Media/rest-assured-logo.svg" width="50" height="50"  alt="Rest-assured"/></a>
<a href="https://www.browserstack.com/"><img src="Media/browserstack.svg" width="50" height="50"  alt="Browserstack"/></a>
<a href="https://developer.android.com/studio"><img src="Media/androidstudio.svg" width="50" height="50"  alt="Android-studio"/></a>
</p>

<a id="verifications"></a>
## :clipboard: Реализованные проверки:

# Mobile testing
- ✓ Провверка кнопки Share в меню навигации
- ✓ Проверка кнопки Edit History в меню навигации
- ✓ Провверка кнопки Categories в меню навигации
- ✓ Провверка кнопки Talk Page в меню навигации

## <img src="Media/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/C16-Denis_Antonov_0_0-projectWikipediaApp/">Сборка в Jenkins</a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/C16-Denis_Antonov_0_0-projectWikipediaApp/"><img src="Media/Jenkins_Build.png" alt="Jenkins"/></a>
</p>

<a id="jenkins-build"></a>
### Параметры сборки в Jenkins:

- Локальный запуск
- Удаленный запуск в Browserstack

<a id="terminal-run"></a>
## :computer: Запуск тестов из терминала

Локальный запуск:
```bash
gradle clean test -Denv=local
```

Удаленный запуск в Jenkins:
```bash
gradle clean test -DrunSetUp=remote -Denv=remote
```

<a id="allure-report"></a>
## <img src="Media/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-Denis_Antonov_0_0-projectWikipediaApp/15/allure/">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="Media/Allure_Report_Overview.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="Media/Allure_Report_Tests.png">
</p>

### Графики

<p align="center">
<img title="Allure Graphics" src="Media/Allure_Report_Graphs.png">
</p>


<a id="allure-TestOps"></a>
## <img src="Media/allureTestOps.svg" width="25" height="25"  alt="Allure TestOps"/></a> Интеграция с Allure TestOps

### Результаты запуска тестов в Allure TestOps

<p align="center">
<img title="Allure TestOps" src="Media/Allure_TestOps_Dashboard.png">
</p>

### Детализация пройденных тестов в Allure TestOps

<p align="center">
<img title="Allure TestOps" src="Media/Allure_TestOps_TestCases.png">
</p>


<a id="telegram-notification"></a>
## <img src="Media/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомление в Telegram

<p align="center">
<img title="Telegram" src="Media/Telegram_notifications.png">
</p>

<a id="browserstack-video"></a>
### <img src="Media/browserstack.svg" width="25" height="25"  alt="Browserstack video"/></a> Видео о прохождении тестов

<p align="center">
<img title="Browserstack Video" src="Media/BrowserstackVideoGif.gif" width="450" height="500"  alt="video"> 
</p>