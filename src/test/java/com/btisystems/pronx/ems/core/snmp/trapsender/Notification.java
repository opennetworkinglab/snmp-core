/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.btisystems.pronx.ems.core.snmp.trapsender;

import java.io.Serializable;
import org.snmp4j.smi.OID;

import com.btisystems.pronx.ems.core.model.DeviceEntity;
import com.btisystems.pronx.ems.core.model.DeviceEntityDescription;
import com.btisystems.pronx.ems.core.model.INotification;

public class Notification extends DeviceEntity implements Serializable, INotification {

	private static final long serialVersionUID = 1L;

	private static final DeviceEntityDescription DESCRIPTION = createEntityDescription();

    private int id;
    private String ip;
    private String string;
    private int unsigned;

    public Notification() {
    }

    public Notification(final int id, final String ip, final String string, final int unsigned) {
        this.id = id;
        this.ip = ip;
        this.string = string;
        this.unsigned = unsigned;
    }


    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        final int oldValue = this.id;
        this.id = id;
        notifyChange(1, oldValue, id);
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(final String ip) {
        final String oldValue = this.ip;
        this.ip = ip;
        notifyChange(4, oldValue, ip);
    }

    public String getString() {
        return this.string;
    }

    public void setString(final String string) {
        final String oldValue = this.string;
        this.string = string;
        notifyChange(5, oldValue, string);
    }

    public int getUnsigned() {
        return unsigned;
    }

    public void setUnsigned(final int unsigned) {
        this.unsigned = unsigned;
    }

    

    @Override
	public String toString() {
		return "Notification [id=" + id + ", ip=" + ip + ", string=" + string + ", unsigned=" + unsigned + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		result = prime * result + unsigned;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (id != other.id)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		if (unsigned != other.unsigned)
			return false;
		return true;
	}

	@Override
    public Notification clone() {
        final Notification copy = new Notification();
        copy.id = id;
        copy.ip = ip;
        copy.string = string;
        copy.unsigned = unsigned;
        return copy;
    }

    private static DeviceEntityDescription createEntityDescription() {
        final DeviceEntityDescription newDescription = new DeviceEntityDescription(new OID("1"));
        newDescription.addField(new DeviceEntityDescription.FieldDescription(1, "id", DeviceEntityDescription.FieldType.INTEGER, -1));
        newDescription.addField(new DeviceEntityDescription.FieldDescription(2, "ip", DeviceEntityDescription.FieldType.IP_ADDRESS, -1));
        newDescription.addField(new DeviceEntityDescription.FieldDescription(3, "string", DeviceEntityDescription.FieldType.STRING, -1));
        newDescription.addField(new DeviceEntityDescription.FieldDescription(4, "unsigned", DeviceEntityDescription.FieldType.UNSIGNED32, -1));
        return newDescription;
    }

    @Override
    public DeviceEntityDescription get_Description() {
        return DESCRIPTION;
    }
}
