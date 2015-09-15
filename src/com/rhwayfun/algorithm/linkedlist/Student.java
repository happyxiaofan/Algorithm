package com.rhwayfun.algorithm.linkedlist;

public class Student {

	private String SID;

	/**
	 * @return the sID
	 */
	public String getSID() {
		return SID;
	}

	/**
	 * @param sID the sID to set
	 */
	public void setSID(String sID) {
		SID = sID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SID == null) ? 0 : SID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (SID == null) {
			if (other.SID != null) {
				return false;
			}
		} else if (!SID.equals(other.SID)) {
			return false;
		}
		return true;
	}
	
	
}
