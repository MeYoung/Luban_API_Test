package ${package.Mapper};

import ${package.Entity}.${entity};
import MyMapperUtils;

/**
 * @author ${author}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends MyMapperUtils<${entity}> {

}
</#if>
