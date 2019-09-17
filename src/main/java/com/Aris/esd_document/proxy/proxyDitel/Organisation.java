package com.Aris.esd_document.proxy.proxyDitel;

import org.springframework.lang.Nullable;

import java.io.Serializable;

public class Organisation implements Serializable {
    private static final long serialVersionUID = 1L;


    @Nullable
    private long idOrganisation;
    private String organisationTitle;
    private long idParent;
    private int isVisible;


    public Organisation(String organisationTitle, long idParent, int isVisible) {
        this.organisationTitle = organisationTitle;
        this.idParent = idParent;
        this.isVisible = isVisible;
    }

    public Organisation() {
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "idOrganisation=" + idOrganisation +
                ", organisationTitle='" + organisationTitle + '\'' +
                ", idParent=" + idParent +
                ", isVisible=" + isVisible +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    public String getOrganisationTitle() {
        return organisationTitle;
    }

    public void setOrganisationTitle(String organisationTitle) {
        this.organisationTitle = organisationTitle;
    }

    public long getIdParent() {
        return idParent;
    }

    public void setIdParent(long idParent) {
        this.idParent = idParent;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
