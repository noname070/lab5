package ru.noname07.lab5.collection.data;

import javax.xml.bind.annotation.XmlEnum;

/**
 * element`s orgType object
 * 
 * @see Organization
 */
@XmlEnum
public enum OrganizationType {
    COMMERCIAL,
    PUBLIC,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY,
    OPEN_JOINT_STOCK_COMPANY;
}
