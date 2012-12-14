//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package tapestry.liferay.portlets.pages.jquery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.got5.tapestry5.jquery.utils.JQueryTabData;

public class JQueryTabs
{
	@Persist
	@Property
	private String activePanel;

	@Persist
	@Property
	private Date sysDate;

	@Property
	private List<JQueryTabData> listTabData;

	@SetupRender
	void onSetupRender()
	{
				
		listTabData = new ArrayList<JQueryTabData>();
        listTabData.add(new JQueryTabData("Panel1","block1"));
        listTabData.add(new JQueryTabData("Panel2","block2"));
        listTabData.add(new JQueryTabData("Panel3","block3"));
        listTabData.add(new JQueryTabData("Panel4","block4"));
        
	}

}
