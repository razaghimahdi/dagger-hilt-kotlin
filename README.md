# dagger-hilt-kotlin



#### developed by  **Mahdi Razzaghi Ghaleh**


Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
Doing  manual dependency injection  requires you to construct every class and its dependencies by hand,
and to use containers to reuse and manage dependencies.


_The goals of Hilt are:_

-   To simplify Dagger-related infrastructure for Android apps.
-   To create a standard set of components and scopes to ease setup, readability/understanding, and code sharing between apps.
-   To provide an easy way to provision different bindings to various build types (e.g. testing, debug, or release).

Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically.
 Hilt is built on top of the popular DI library  Dagger  to benefit from the compile-time correctness, runtime performance, scalability, and  Android Studio support  that Dagger provides.

All apps that use Hilt must contain an  `Application`  class that is annotated with  `@HiltAndroidApp`.

`@HiltAndroidApp`  triggers Hilt's code generation, including a base class for your application that serves as the application-level dependency container.

There is 2 type of injection that you can use : Field injection, Constructor Injection.
Field Injection:
Constructor Injection:


### Scope and Component
Unlike traditional Dagger,
 Hilt users never define or instantiate Dagger components directly.
  Instead, Hilt offers predefined components that are generated for you.
   Hilt comes with a built-in set of components (and corresponding scope annotations) that are automatically integrated into the various lifecycles of an Android application.

if you annotate a dependency with singleton that dependency is gonna live as long

<img src="screenshots/scope.png" width="300">
<img src="screenshots/scope2.png" width="300">




