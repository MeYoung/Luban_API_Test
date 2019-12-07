package ${package.Service};

import ${package.Entity}.${entity};

/**
 * @author ${author}
 */
<#if kotlin>
interface ${table.serviceName}
<#else>
public interface ${table.serviceName}{

}
</#if>
