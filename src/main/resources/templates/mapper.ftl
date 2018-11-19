package ${classPathMapper};

import ${classPathModel}.${className};
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ${className}Mapper {
    public ${className} select(${className} ${className?uncap_first});
    public List<${className}> selectList(${className} ${className?uncap_first});
    public int insert(${className} ${className?uncap_first});
    public int update(${className} ${className?uncap_first});
    public int delete(${className} ${className?uncap_first});
}