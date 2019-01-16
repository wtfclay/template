<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${classPathMapper}.${className}Mapper">
    <resultMap id="BaseResultMap" type="${classPathModel}.${className}">
    <#if columnList??>
        <#list columnList as column>
        <#if column.pk==true><id <#else><result </#if>column="${column.columnName}" property="${column.javaColumn}" jdbcType="${column.typeName}" />
        </#list>
    </#if>
    </resultMap>

    <sql id="Base_Column_Select">
        <#list columnList as column>
        ${column.columnName}<#if column_has_next>,</#if>
        </#list>
    </sql>

    <sql id="Base_Column_Where">
        <where>
        <#list columnList as column>
        <#if column.pk==false>
            <if test="${column.javaColumn} != null<#if column.typeName=='TIMESTAMP'> "> <#else> and ${column.javaColumn} !='' "></#if>
                AND ${column.columnName} = <#noparse>#</#noparse>{${column.javaColumn},jdbcType=${column.typeName}}
            </if>
        </#if>
        </#list>
        </where>
    </sql>
    <select id="select" resultMap="BaseResultMap" parameterType="${classPathModel}.${className}">
        select
        <include refid="Base_Column_Select" />
        from ${tableName}
        <include refid="Base_Column_Where"></include> limit 1
    </select>

    <select id="selectList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_Select" />
        from ${tableName}
        <include refid="Base_Column_Where"></include>
    </select>

    <insert id="insert" parameterType="${classPathModel}.${className}">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            <#list columnList as column>
            <if test="${column.javaColumn} != null ">
                ${column.columnName},
            </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            <#list columnList as column>
            <if test="${column.javaColumn} != null ">
                <#noparse>#</#noparse>{${column.javaColumn},jdbcType=${column.typeName}},
            </if>
            </#list>
        </trim>
    </insert>

    <update id="update" parameterType="${classPathModel}.${className}" >
        update ${tableName}
        <set>
        <#list columnList as column>
            <#if column.pk==false>
            <if test="${column.javaColumn} != null<#if column.typeName=='TIMESTAMP'> "> <#else> and ${column.javaColumn} !='' "></#if>
                ${column.columnName} = <#noparse>#</#noparse>{${column.javaColumn},jdbcType=${column.typeName}},
            </if>
            </#if>
        </#list>
        </set>
        where
        <#list columnList as column>
        <#if column.pk==true>
        ${column.columnName} = <#noparse>#</#noparse>{${column.javaColumn},jdbcType=${column.typeName}}
        </#if>
    </#list>
    </update>

    <update id="updateInfo" parameterType="java.util.Map" >
        update ${tableName}
        <set>
            <#list columnList as column>
            <#if column.pk==false>
            <if test="${column.javaColumn}New != null<#if column.typeName=='TIMESTAMP'> "> <#else> and ${column.javaColumn} !='' "></#if>
                ${column.columnName} = <#noparse>#</#noparse>{${column.javaColumn}New,jdbcType=${column.typeName}},
            </if>
            </#if>
            </#list>
        </set>
        <include refid="Base_Column_Where"></include>
    </update>

    <delete id="delete" parameterType="${classPathModel}.${className}">
        delete from ${tableName}
        <include refid="Base_Column_Where"></include>
    </delete>
</mapper>
