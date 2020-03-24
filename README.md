# AnimalSpecification

Необходимое ПО 
1. JDK 1.8 
2. MySQL Server 8.* 
3. git 
4. Node.js LTS (https://nodejs.org/en/)
5. WildFly

Правила наменования веток. Все ветки, связанные с разработкой образуюттся от ветки feature/<Название задачи> Самые крутные задачи выполнять в отдельных ветках, которые создавать из ветки в develop

Правила формирования SQL миграций Каждая новая мигррация описывается в новом .xml файле в папке resources/connfig/liquibase/changelog Наименование миграции это чисто месяц год час и минута создания миграции и краткое описание измений (пример - тестовая сущность) Если делаются какие-либо изменения в БД - создаётся отдельна миграция

Создания новой миграции, ссылка на этот файл добавляется в master.xml

Данные для подключения описываются в database.properties (ссылку лучше всего не трогать, свои пароли в гит не заливать)

Выполнения запросов к БД потам решим как делать, но пока остаётся JDBC Template, можно попробоваться сделать тестовые классы чтобы проверить как оно вообще работает. Да и вообще, любые вещи можно будет проверять на тестовом классе(например)

Запуск проекта.
1. Убедиться, что создана БД
2. Выполнить команду npm install через терминал, Идею, VS Code из директории проекта (/AnimalSpecification)
3. Запустить БЭК через Идею
4. Запустить фронт командой npm start
5. Учётка для аворизации: login : admin , password : admiin (Запрос авторизаии временно отключен)
6. Swagger пока что доступен только со стандартных страниц БЭКА



This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.0.6.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
