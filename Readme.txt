Step by step Clean Architecture:
1. Build the Architecture first, which will be:
   - create package: 'Core'.'util' (to use scalable util)
   - create package per function your apps does, for this apps example just one feature which is
     'dictionary_feature'
   - then create another package inside feature package that will be:
     -- package: 'data' -> 'local'.'entity'
                      -> 'remote'.'dto'
     -- package: 'di' (for dependency injection)
     -- package: 'domain' -> 'model'
                        -> 'repository'
                        -> 'use_case'
   - then create package: 'presentation'

2. After all package created, then create the remote DTO class first
3. then create model class which is the same like DTO
4. create function to map data from DTO to model in DTO class
5. create entity data class that needed and function to map into model
6. create Dao interface in local.entity package
7. create abstract class Room database in package entity
8. create Resource sealed class to distinguish between loading, success, and error states in core.util package
9. create interface repository in domain.repository package
10. create repository package in data.remote package, and create repositoryImplementation class there.
11. create usecase class in domain.usecase package (not all necessary)
12. create viewModel and State class in presentation package
13. setup DI by creating application class and register to manifest
14. setup module object for DI in di package
15. setup UI and dont forget to annotate every activity or fragment with @AndroidEntryPoint