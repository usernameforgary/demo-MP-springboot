## mybatis plus demo with spring boot ##

### Some Notes ###

- Pagination configuration
    - ```new paginationInnerInterceptor()```
- MapperScan annotation 
    - ``@MapperScan("pacakge of mapper class")``
- mappedStatements
    - ``ISqlInjector`` interface
    - ``AbstractSqlInjector`` implement ``ISqlInjector`` override ``inspectInject`` method. ``methodList.forEach(m -> m.inject(**)``
    - methods in ``BaseMapper`` extends ``AbstractMethod`` implements ``injectMappedStatement`` abstract method
- How to customization BaseMapper with new method?
    - new class extends AbstractMethod
    - new injector override getMethodList method, add the method defined
    - config mybatis plus with the new injector