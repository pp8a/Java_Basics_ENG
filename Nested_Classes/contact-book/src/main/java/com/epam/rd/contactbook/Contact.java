package com.epam.rd.contactbook;

import java.util.Arrays;

public class Contact {
	private String contactName;
	private int phoneNumber = 0; //only a single one
	private int emails = 0; //up to 3 entries
	private final int MAX_EMAILS = 3;
	private int socialMedia = 0; //up to 5 entries
	private final int MAX_SOCIAL = 5;
	private ContactInfo[] contactInfos;	
	private int capacity = 1;
	private ContactInfo[] contactEmail;
	private ContactInfo[] contactSocial;
	private ContactInfo[] contactPhone;
		
    public Contact(String contactName) {
        this.contactName = contactName;
        contactEmail = new ContactInfo[MAX_EMAILS];
        contactSocial = new ContactInfo[MAX_SOCIAL];
    }
    
    @SuppressWarnings("unused")
	private class NameContactInfo implements ContactInfo{

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return "Name";
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return contactName;
		}
    	
    }
    
    public static class Email implements ContactInfo{
    	private String title;
    	private String value;
    	
		public Email(String title, String value) {
			super();
			this.title = title;
			this.value = value;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return title;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return value;
		}    	
    }
    
    public static class Social implements ContactInfo{
    	private String title;
    	private String value;
    	
		public Social(String title, String value) {
			super();
			this.title = title;
			this.value = value;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return title;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return value;
		}
    	
    }
    
    public void rename(String newName) {
        if(newName != null && !newName.equals("")) {
        	contactName = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
    	if(emails < MAX_EMAILS) {
    		Email email = new Email("Email", localPart+"@"+domain);
    		contactEmail[emails++] = email;
    		capacity++;
    		return email;
    	}
		return null;        
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if(emails < MAX_EMAILS) {
        	Email email = new Contact.Email(firstname, lastname) {

				@Override
				public String getTitle() {
					// TODO Auto-generated method stub
					return "Epam Email";
				}

				@Override
				public String getValue() {
					// TODO Auto-generated method stub
					return firstname+"_"+lastname+"@epam.com";
				}
        		
        	};
        	contactEmail[emails++] = email;
        	capacity++;
        	return email;
        }
		return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
    	if(phoneNumber < 1) {
    		ContactInfo contactInfo = new ContactInfo() {
    			
    			@Override
    			public String getValue() {
    				// TODO Auto-generated method stub
    				return "+"+code+" "+number;
    			}
    			
    			@Override
    			public String getTitle() {
    				// TODO Auto-generated method stub
    				return "Tel";
    			}
    		};
    		contactPhone = new ContactInfo[1];
    		contactPhone[phoneNumber++] = contactInfo;
    		capacity++;
    		return contactInfo;
    	}
        return null;
    }

    public Social addTwitter(String twitterId) {
        if(socialMedia < MAX_SOCIAL) {
        	Social social = new Contact.Social("Twitter", twitterId);
        	contactSocial[socialMedia++] = social;
        	capacity++;
        	return social;
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        if(socialMedia < MAX_SOCIAL) {
        	Social social = new Contact.Social("Instagram", instagramId);
        	contactSocial[socialMedia++] = social;
        	capacity++;
        	return social;
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        if(socialMedia < MAX_SOCIAL) {
        	Social social = new Contact.Social(title, id);
        	contactSocial[socialMedia++] = social;
        	capacity++;
        	return social;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
    	if(capacity!=0) {
    		int i = 0;
        	contactInfos = new ContactInfo[capacity];
        	contactInfos[i++] = new NameContactInfo();
        	capacity--;        	
        	
        	if(phoneNumber > 0) {
        		contactInfos[i++]=contactPhone[0];
    			capacity--;
        	}
        	
        	if(emails > 0) { 
        		int j = 0;
        		while(emails > 0) {    			
        			contactInfos[i++]=contactEmail[j++];        			
        			capacity--;
        			emails--;
        		}
        	}
        	
        	if(socialMedia > 0) {  
        		int j = 0;
        		while(socialMedia > 0) {    			
        			contactInfos[i++]=contactSocial[j++];        			
        			capacity--;
        			socialMedia--;
        		}
        	}
    	}
    	
    	System.out.println(Arrays.toString(contactInfos));
		return contactInfos;        
    }

}
