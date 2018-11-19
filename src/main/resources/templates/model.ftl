package ${classPathModel};

import lombok.Data;

@Data
public class ${className} {
<#if columnList??>
    <#list columnList as column>
     private ${column.javaType} ${column.javaColumn};
    </#list>
</#if>
}