package clases;

/*
 * Profesor.java
 *
 * Generated with Matisse Schema Definition Language 9.1.11
 * Generation date: Fri Feb 08 13:00:32 2019
 */

// Note: the package and extends declarations are generated by mt_sdl, do not modify them

import com.matisse.reflect.*;

/**
 * <code>Profesor</code> is a schema class generated by <code>mt_sdl</code>.
 * Any user-written classes will be found at the end of the file, after
 * the '// END of Matisse SDL Generated Code' comment.
 * Attribute types, default values, and relationship minimum and maximum
 * cardinality are stored in the database itself, not in this source code.
 * For more information, see <i>Getting Started with MATISSE</i>.
 */
public class Profesor extends com.matisse.reflect.MtObject {

    // BEGIN Matisse SDL Generated Code
    // DO NOT MODIFY UNTIL THE 'END of Matisse SDL Generated Code' MARK BELOW
    /*
     * Generated with Matisse Schema Definition Language 9.1.11
     * Generation Date: Fri Feb 08 13:00:32 2019
     */

    /*
     * Class variables and methods
     */

    /** Class <code>Profesor</code> cache ID */
    private static int CID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtClass.Loader("Profesor"));

    /**
     * Gets the <code>Profesor</code> class descriptor.
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
    public Profesor(com.matisse.MtDatabase db, int mtOid)  {
        super(db, mtOid);
    }

    /**
     * Cascaded constructor, used by subclasses to create a new object in the database.
     * It is protected for technical reasons but is not intended to be called
     * directly by user methods.
     * @param mtCls a class descriptor (the class to instantiate)
     */
    protected Profesor(com.matisse.reflect.MtClass mtCls)  {
        super(mtCls);
    }

    /**
     * Opens an iterator on all instances of this class (and its subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> instanceIterator(com.matisse.MtDatabase db) {
        return getClass(db).<E>instanceIterator(Profesor.class);
    }

    /**
     * Opens an iterator on all instances of this class (and its subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @param numObjPerBuffer maximum number of objects to fetch from the server at a time
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> instanceIterator(com.matisse.MtDatabase db, int numObjPerBuffer) {
        return getClass(db).<E>instanceIterator(numObjPerBuffer, Profesor.class);
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
        return getClass(db).<E>ownInstanceIterator(Profesor.class);
    }

    /**
     * Opens an iterator on all own instances of this class (excluding subclasses).
     * @param <E> a MtObject class     * @param db a database
     * @param numObjPerBuffer maximum number of objects to fetch from the server at a time
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> ownInstanceIterator(com.matisse.MtDatabase db, int numObjPerBuffer) {
        return getClass(db).<E>ownInstanceIterator(numObjPerBuffer, Profesor.class);
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

    /* Attribute 'nombre' */

    /** Attribute <code>nombre</code> cache ID */
    private static int nombreCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("nombre",CID));

    /**
     * Gets the <code>nombre</code> attribute descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getNombreAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute)db.getCachedObject(nombreCID);
    }


    /**
     * Gets the <code>nombre</code> attribute value.
     * @return the value
     *
     * @see #setNombre
     * @see #removeNombre
     */
    public final String getNombre() {
        return getString(getNombreAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>nombre</code> attribute value.
     * @param val the new value
     *
     * @see #getNombre
     * @see #removeNombre
     */
    public final void setNombre(String val) {
        setString(getNombreAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>nombre</code> attribute value.
     * Falls back to the default value is there is one.  If the attribute
     * has no default value, it must be set to a new value before commit.
     *
     * @see #getNombre
     * @see #setNombre
     */
    public final void removeNombre() {
        removeValue(getNombreAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     * @return true if default value
     *
     * @see #getNombre
     * @see #setNombre
     */
    public final boolean isNombreDefaultValue() {
        return isDefaultValue(getNombreAttribute(getMtDatabase()));
    }


    /* Attribute 'email' */

    /** Attribute <code>email</code> cache ID */
    private static int emailCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("email",CID));

    /**
     * Gets the <code>email</code> attribute descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getEmailAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute)db.getCachedObject(emailCID);
    }


    /**
     * Gets the <code>email</code> attribute value.
     * @return the value
     *
     * @see #setEmail
     * @see #removeEmail
     */
    public final String getEmail() {
        return getString(getEmailAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>email</code> attribute value.
     * @param val the new value
     *
     * @see #getEmail
     * @see #removeEmail
     */
    public final void setEmail(String val) {
        setString(getEmailAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>email</code> attribute value.
     * Falls back to the default value is there is one.  If the attribute
     * has no default value, it must be set to a new value before commit.
     *
     * @see #getEmail
     * @see #setEmail
     */
    public final void removeEmail() {
        removeValue(getEmailAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     * @return true if default value
     *
     * @see #getEmail
     * @see #setEmail
     */
    public final boolean isEmailDefaultValue() {
        return isDefaultValue(getEmailAttribute(getMtDatabase()));
    }


    /* Attribute 'ingreso' */

    /** Attribute <code>ingreso</code> cache ID */
    private static int ingresoCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("ingreso",CID));

    /**
     * Gets the <code>ingreso</code> attribute descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getIngresoAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute)db.getCachedObject(ingresoCID);
    }


    /**
     * Gets the <code>ingreso</code> attribute value.
     * @return the value
     *
     * @see #setIngreso
     * @see #removeIngreso
     */
    public final int getIngreso() {
        return getInteger(getIngresoAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>ingreso</code> attribute value.
     * @param val the new value
     *
     * @see #getIngreso
     * @see #removeIngreso
     */
    public final void setIngreso(int val) {
        setInteger(getIngresoAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>ingreso</code> attribute value.
     * Falls back to the default value is there is one.  If the attribute
     * has no default value, it must be set to a new value before commit.
     *
     * @see #getIngreso
     * @see #setIngreso
     */
    public final void removeIngreso() {
        removeValue(getIngresoAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     * @return true if default value
     *
     * @see #getIngreso
     * @see #setIngreso
     */
    public final boolean isIngresoDefaultValue() {
        return isDefaultValue(getIngresoAttribute(getMtDatabase()));
    }


    /*
     * Relationship access methods
     */

    /* Relationship 'dirige' */

    /** Relationship <code>dirige</code> cache ID */
    private static int dirigeCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtRelationship.Loader("dirige",CID));

    /**
     * Gets the <code>dirige</code> relationship descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db a database
     * @return a relationship descriptor object
     */
    public static com.matisse.reflect.MtRelationship getDirigeRelationship(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtRelationship)db.getCachedObject(dirigeCID);
    }

    /**
     * Gets the <code>dirige</code> relationship's successors.
     * @return an array of objects
     *
     * @see #getDirigeSize
     * @see #dirigeIterator
     * @see #setDirige
     * @see #removeDirige
     */
    public final Tesis[] getDirige() {
        return (Tesis[])getSuccessors(getDirigeRelationship(getMtDatabase()), Tesis.class);
    }

    /**
     * Counts the <code>dirige</code> relationship's successors.
     * @return the number of successors
     *
     * @see #getDirige
     * @see #dirigeIterator
     * @see #setDirige
     * @see #removeDirige
     */
    public final int getDirigeSize() {
        return getSuccessorSize(getDirigeRelationship(getMtDatabase()));
    }

    /**
     * Opens an iterator on the <code>dirige</code> relationship's successors.
     * @param <E> a MtObject class     * @return an object iterator
     *
     * @see #getDirige
     * @see #getDirigeSize
     * @see #setDirige
     * @see #removeDirige
     */
    public final <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> dirigeIterator() {
        return this.<E>successorIterator(getDirigeRelationship(getMtDatabase()), Tesis.class);
    }

    /**
     * Sets the <code>dirige</code> relationship's successors.
     * @param succs an array of objects
     *
     * @see #getDirige
     * @see #getDirigeSize
     * @see #dirigeIterator
     * @see #removeDirige
     */
    public final void setDirige(Tesis[] succs) {
        setSuccessors(getDirigeRelationship(getMtDatabase()), succs);
    }

    /**
     * Inserts one object at the beginning of the existing <code>dirige</code> successors list.
     * @param succ the object to add
     *
     * @see #getDirige
     * @see #getDirigeSize
     * @see #dirigeIterator
     * @see #setDirige
     * @see #removeDirige
     */
    public final void prependDirige(Tesis succ) {
        prependSuccessor(getDirigeRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds one object to the end of the existing <code>dirige</code> successors list.
     * @param succ the object to add
     *
     * @see #getDirige
     * @see #setDirige
     * @see #removeDirige
     * @see #getDirigeSize
     * @see #dirigeIterator
     */
    public final void appendDirige(Tesis succ) {
        appendSuccessor(getDirigeRelationship(getMtDatabase()), succ);
    }
    /** Adds multiple objects to the end of the existing <code>dirige</code> successors list.
     * @param succs an array of objects to add
     *
     * @see #getDirige
     * @see #setDirige
     * @see #removeDirige
     * @see #getDirigeSize
     * @see #dirigeIterator
     */
    public final void appendDirige(Tesis[] succs) {
        addSuccessors(getDirigeRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes objects from the <code>dirige</code> successors list.
     * @param succs an array of objects to remove
     *
     * @see #getDirige
     * @see #setDirige
     * @see #getDirigeSize
     * @see #dirigeIterator
     */
    public void removeDirige(Tesis[] succs) {
        removeSuccessors(getDirigeRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes one object from the <code>dirige</code> successors list.
     * @param succ the object to remove
     *
     * @see #getDirige
     * @see #setDirige
     * @see #getDirigeSize
     * @see #dirigeIterator
     */
    public void removeDirige(Tesis succ) {
        removeSuccessor(getDirigeRelationship(getMtDatabase()), succ);
    }

    /**
     * Removes all <code>dirige</code> successors.  When the minimum cardinality
     * is 1, a new successor must be set before commit.
     */
    public final void clearDirige() {
        clearSuccessors(getDirigeRelationship(getMtDatabase()));
    }


    /* Relationship 'pertenece' */

    /** Relationship <code>pertenece</code> cache ID */
    private static int perteneceCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtRelationship.Loader("pertenece",CID));

    /**
     * Gets the <code>pertenece</code> relationship descriptor.
     * This method supports advanced MATISSE programming techniques such as
     * dynamically modifying the schema.
     * @param db a database
     * @return a relationship descriptor object
     */
    public static com.matisse.reflect.MtRelationship getPerteneceRelationship(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtRelationship)db.getCachedObject(perteneceCID);
    }

    /**
     * Gets the <code>pertenece</code> sucessor object.
     * @return an object 
     *
     * @see #setPertenece
     * @see #clearPertenece
     */
    public final Departamento getPertenece() {
        return (Departamento)getSuccessor(getPerteneceRelationship(getMtDatabase()));
    }

    /**
     * Sets the <code>pertenece</code> successor object. It is not necessary to clear the
     * relationship before setting a new successor.
     * @param succ the new successor object
     *
     * @see #getPertenece
     * @see #clearPertenece
     */
    public final void setPertenece(Departamento succ) {
        setSuccessor(getPerteneceRelationship(getMtDatabase()), succ);
    }

    /**
     * Removes all <code>pertenece</code> successors.  When the minimum cardinality
     * is 1, a new successor must be set before commit.
     */
    public final void clearPertenece() {
        clearSuccessors(getPerteneceRelationship(getMtDatabase()));
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
    public Profesor(com.matisse.MtDatabase db) {
        super(getClass(db));
    }

    /**
     * Example of <code>toString</code> method.
     * You may delete this method or modify it to suit your needs. If you
     * modify it, please revise this comment accordingly.
     * @return a string
     */
    public java.lang.String toString() {
        return super.toString() + "[Profesor]";
    }
}
