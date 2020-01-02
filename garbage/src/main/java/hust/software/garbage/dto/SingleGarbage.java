package hust.software.garbage.dto;

/**
 * @author: 小栗旬
 * @Date: 2020/1/2 9:45
 */
public class SingleGarbage {
    private Integer id;
    private String name;
    private Integer typeId;
    private String typeName;

    public SingleGarbage(Integer id, String name, Integer typeId, String typeName) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public SingleGarbage(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
