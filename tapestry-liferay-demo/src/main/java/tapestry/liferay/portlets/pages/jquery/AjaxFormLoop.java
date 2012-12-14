//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package tapestry.liferay.portlets.pages.jquery;

import java.util.Date;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import tapestry.liferay.portlets.data.entities.Person;
import tapestry.liferay.portlets.data.entities.Phone;
import tapestry.liferay.portlets.pages.Index_jQuery;


public class AjaxFormLoop
{
	
    @Property
    @Persist
    private Person person;

    @Property
    private Phone phone;
    
    @Property
    private Boolean deleted;

    @OnEvent("activate")
    void init()
    {
        if (person == null)
            person = new Person();
        
        
    }

    public ValueEncoder<Phone> getPhoneEncoder()
    {
        return new ValueEncoder<Phone>()
        {

            public String toClient(Phone value)
            {
                return value.getNumber();
            }

            public Phone toValue(String clientValue)
            {
                for (Phone currentPhone : person.getPhones())
                {
                    if (currentPhone.getNumber() != null && clientValue.equals(currentPhone.getNumber()))
                        return currentPhone;
                }
                return null;
            }
        };
    }

    public Object onSuccess()
    {
        return Index_jQuery.class;
    }

    public Object onAddRowFromPhones()
    {
        Phone phone = new Phone();
        phone.setNumber("");
        phone.setStartDate(new Date());

        person.getPhones().add(phone);
        phone.setPerson(person);
    
        return phone;
    }
    
    void onRemoveRowFromPhones(Phone phoneToDelete) 
    {
    	person.getPhones().remove(phoneToDelete);
    	// If the phone is new, remove them from the list. Else, flag them to be deleted from the database.
	}

 
    
}
