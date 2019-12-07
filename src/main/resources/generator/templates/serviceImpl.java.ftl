package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import lombok.extern.slf4j.Slf4j;

/**
 * @author ${author}
 */
@Slf4j
<#if kotlin>
open class ${table.serviceImplName} {

}
<#else>
public class ${table.serviceImplName} {

}
</#if>
