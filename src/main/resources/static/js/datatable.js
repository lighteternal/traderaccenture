$(document).ready( function () {
	 var table = $('#activitiesTable').DataTable({
		 "sAjaxSource": "activities",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "txID"},
		      { "mData": "creationDate"   },
				  { "mData": "stockAmount" },
				  { "mData": "stockID" },
				  { "mData": "stockPrice" },
				  { "mData": "type" }
			]
	 })
});