package generated;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "newAuthor"
})
@XmlRootElement(name = "LibraryRequest4")
public class LibraryRequest4 {
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String newAuthor;

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    public String getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(String newAuthor) {
        this.newAuthor = newAuthor;
    }
}
