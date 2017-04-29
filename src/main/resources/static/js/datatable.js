$(document).ready( function () {
	 var table = $('#activitiesTable').DataTable({
		 "sAjaxSource": "/activ",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "txID"},
		      { "mData": "creationDate"   },
				  { "mData": "stockAmount" },
				  { "mData": "sname" },
				  { "mData": "stockPrice" },
				  { "mData": "type" }
			]
	 })
});