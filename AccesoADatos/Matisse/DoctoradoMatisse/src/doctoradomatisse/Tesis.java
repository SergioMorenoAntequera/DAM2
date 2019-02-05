/*
 * Tesis.java
 *
 * Generated with Matisse Schema Definition Language 9.1.11
 * Generation date: Tue Feb 05 09:09:45 2019
 */

// Note: the package and extends declarations are generated by mt_sdl, do not modify them

package doctoradomatisse;

import com.matisse.reflect.*;

/**
 * <code>Tesis</code> is a schema class generated by <code>mt_sdl</code>.
 * Any user-written classes will be found at the end of the file, after
 * the '// END of Matisse SDL Generated Code' comment.
 * Attribute types, default values, and relationship minimum and maximum
 * cardinality are stored in the database itself, not in this source code.
 * For more information, see <i>Getting Started with MATISSE</i>.
 */
public class Tesis extends com.matisse.reflect.MtObject {

    // BEGIN Matisse SDL Generated Code
    // DO NOT MODIFY UNTIL THE 'END of Matisse SDL Generated Code' MARK BELOW
    /*
     * Generated with Matisse Schema Definition Language 9.1.11
     * Generation Date: Tue Feb 05 09:09:45 2019
     */

    /*
     * Class variables and methods
     */

    /** Class <code>Tesis</code> cache ID */
    private static int CID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtClass.Loader("doctoradomatisse.Tesis"));

    /**
     * Gets the <code>Tesis</code> class descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db a database
     * @return a class descriptor
     */
    public static com.matisse.reflect.MtClass getClass(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtClass)db.getCachedObject(CID);
    }

    /**
     * Factory constructor. This constructor is called by <code>MtObjectFactory</code>.
     * It is public for technical reasons but is not intended to be called
     * directly by user methods.
     * @param db a database
     * @param mtOid an existing object ID in the database
     */
    public Tesis(com.matisse.MtDatabase db, int mtOid)  {
        super(db, mtOid);
    }

    /**
     * Cascaded constructor, used by subclasses to create a new object in the database.
     * It is protected for technical reasons but is not intended to be called
     * directly by user methods.
     * @param mtCls a class descriptor (the class to instantiate)
     */
    protected Tesis(com.matisse.reflect.MtClass mtCls)  {
        super(mtCls);
    }

    /**
     * Opens an iterator on all instances of this class (and its subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> instanceIterator(com.matisse.MtDatabase db) {
        return getClass(db).<E>instanceIterator(Tesis.class);
    }

    /**
     * Opens an iterator on all instances of this class (and its subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @param numObjPerBuffer maximum number of objects to fetch from the server at a time
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> instanceIterator(com.matisse.MtDatabase db, int numObjPerBuffer) {
        return getClass(db).<E>instanceIterator(numObjPerBuffer, Tesis.class);
    }

    /**
     * Counts the number of instances of this class (and its subclasses).
     * @param db a database
     * @return total number of instances
     */
    public static long getInstanceNumber(com.matisse.MtDatabase db) {
        return getClass(db).getInstanceNumber();
    }

    /**
     * Opens an iterator on all own instances of this class (excluding subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> ownInstanceIterator(com.matisse.MtDatabase db) {
        return getClass(db).<E>ownInstanceIterator(Tesis.class);
    }

    /**
     * Opens an iterator on all own instances of this class (excluding subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @param numObjPerBuffer maximum number of objects to fetch from the server at a time
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> ownInstanceIterator(com.matisse.MtDatabase db, int numObjPerBuffer) {
        return getClass(db).<E>ownInstanceIterator(numObjPerBuffer, Tesis.class);
    }

    /**
     * Counts the number of own instances of this class (excluding subclasses).
     * @param db a database
     * @return total number of instances
     */
    public static long getOwnInstanceNumber(com.matisse.MtDatabase db) {
        return getClass(db).getOwnInstanceNumber();
    }

    /*
     * Attribute access methods
     */

    /* Attribute 'titulo' */

    /** Attribute <code>titulo</code> cache ID */
    private static int tituloCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("titulo",CID));

    /**
     * Gets the <code>titulo</code> attribute descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getTituloAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute)db.getCachedObject(tituloCID);
    }


    /**
     * Gets the <code>titulo</code> attribute value.
     * @return the value
     *
     * @see #setTitulo
     * @see #removeTitulo
     */
    public final String getTitulo() {
        return getString(getTituloAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>titulo</code> attribute value.
     * @param val the new value
     *
     * @see #getTitulo
     * @see #removeTitulo
     */
    public final void setTitulo(String val) {
        setString(getTituloAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>titulo</code> attribute value.
     * Falls back to the default value is there is one.  If the attribute
     * has no default value, it must be set to a new value before commit.
     *
     * @see #getTitulo
     * @see #setTitulo
     */
    public final void removeTitulo() {
        removeValue(getTituloAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     * @return true if default value
     *
     * @see #getTitulo
     * @see #setTitulo
     */
    public final boolean isTituloDefaultValue() {
        return isDefaultValue(getTituloAttribute(getMtDatabase()));
    }


    /* Attribute 'tema' */

    /** Attribute <code>tema</code> cache ID */
    private static int temaCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("tema",CID));

    /**
     * Gets the <code>tema</code> attribute descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getTemaAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute)db.getCachedObject(temaCID);
    }


    /**
     * Gets the <code>tema</code> attribute value.
     * @return the value
     *
     * @see #setTema
     * @see #removeTema
     */
    public final String getTema() {
        return getString(getTemaAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>tema</code> attribute value.
     * @param val the new value
     *
     * @see #getTema
     * @see #removeTema
     */
    public final void setTema(String val) {
        setString(getTemaAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>tema</code> attribute value.
     * Falls back to the default value is there is one.  If the attribute
     * has no default value, it must be set to a new value before commit.
     *
     * @see #getTema
     * @see #setTema
     */
    public final void removeTema() {
        removeValue(getTemaAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     * @return true if default value
     *
     * @see #getTema
     * @see #setTema
     */
    public final boolean isTemaDefaultValue() {
        return isDefaultValue(getTemaAttribute(getMtDatabase()));
    }


    /*
     * Relationship access methods
     */

    /* Relationship 'es_dirigida' */

    /** Relationship <code>es_dirigida</code> cache ID */
    private static int es_dirigidaCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtRelationship.Loader("es_dirigida",CID));

    /**
     * Gets the <code>es_dirigida</code> relationship descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db a database
     * @return a relationship descriptor object
     */
    public static com.matisse.reflect.MtRelationship getEs_dirigidaRelationship(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtRelationship)db.getCachedObject(es_dirigidaCID);
    }

    /**
     * Gets the <code>es_dirigida</code> sucessor object.
     * @return an object 
     *
     * @see #setEs_dirigida
     * @see #clearEs_dirigida
     */
    public final doctoradomatisse.Profesor getEs_dirigida() {
        return (doctoradomatisse.Profesor)getSuccessor(getEs_dirigidaRelationship(getMtDatabase()));
    }

    /**
     * Sets the <code>es_dirigida</code> successor object. It is not necessary to clear the
     * relationship before setting a new successor.
     * @param succ the new successor object
     *
     * @see #getEs_dirigida
     * @see #clearEs_dirigida
     */
    public final void setEs_dirigida(doctoradomatisse.Profesor succ) {
        setSuccessor(getEs_dirigidaRelationship(getMtDatabase()), succ);
    }

    /**
     * Removes all <code>es_dirigida</code> successors.  When the minimum cardinality
     * is 1, a new successor must be set before commit.
     */
    public final void clearEs_dirigida() {
        clearSuccessors(getEs_dirigidaRelationship(getMtDatabase()));
    }


    // END of Matisse SDL Generated Code

    /*
     * You may add your own code here...
     */

    /**
     * Default constructor provided as an example.
     * You may delete this constructor or modify it to suit your needs. If you
     * modify it, please revise this comment accordingly.
     * @param db a database
     */
    public Tesis(com.matisse.MtDatabase db) {
        super(getClass(db));
    }

    /**
     * Example of <code>toString</code> method.
     * You may delete this method or modify it to suit your needs. If you
     * modify it, please revise this comment accordingly.
     * @return a string
     */
    public java.lang.String toString() {
        return super.toString() + "[Tesis]";
    }
}
