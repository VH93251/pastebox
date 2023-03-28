package vh.projects.pastebox.model.dto;

import static vh.projects.pastebox.model.PasteBox.AccessStatus;


public record RequestPasteBoxDto(String paste, AccessStatus accessStatus, long liveTime){}


