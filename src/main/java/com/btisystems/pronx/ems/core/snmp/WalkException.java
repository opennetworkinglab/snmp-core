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
package com.btisystems.pronx.ems.core.snmp;


import com.btisystems.pronx.ems.core.exception.DetailedFaultException;

/**
 * Thrown when walk is interrupted by an exception
 */
public class WalkException extends DetailedFaultException {

    private static final long serialVersionUID = -2285401779827218734L;

    /**
     * Instantiates a new Walk exception.
     *
     * @param message the message
     */
    public WalkException(final String message) {
        super("Walk terminated [%1$s]", message);
    }
}
