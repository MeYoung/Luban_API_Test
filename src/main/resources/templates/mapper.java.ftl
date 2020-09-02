package ${package.Mapper};

import ${package.Entity}.${entity};
import com.lucky.common.utils.MyMapperUtils;

/**
 * @author ${author}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends MyMapperUtils<${entity}> {

}
</#if>
