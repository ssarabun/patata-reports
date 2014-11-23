/*
 *  Copyright (C) 2014 sergey.sarabun@gmail.com.
 * 
 *  This library is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public 
 *  License as published by the Free Software Foundation, either 
 *  version 3 of the License, or (at your option) any later version.
 * 
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.googlecode.patata.reports.model;

import com.googlecode.patata.reports.model.spi.IColumnDefinition;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
@Entity
@Table(name = "rs_group")
public class Group extends UUIDAbstractEntity {

    private String id;
    private String name;
    private String description;
    private Group parent;
    private Set<Group> children = new HashSet<Group>();

    public Group() {
    }

    public Group(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "group_id", nullable = false, unique = true)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", columnDefinition = IColumnDefinition.TEXT_COLUMN_DEFINITION)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    public Set<Group> getChildren() {
        return children;
    }

    public void setChildren(Set<Group> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 63 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof DataSource)) {
            return false;
        }

        final Group other = (Group) obj;
        if (this.getId() == null || !Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }
}