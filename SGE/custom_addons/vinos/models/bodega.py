# -*- coding: utf-8 -*-

from odoo import models, fields, api
from datetime import datetime

## Modelo bodega
class bodega(models.Model):
	_name = 'bodega.vinos'
	_description = 'bodega'

	name = fields.Char(string='Nombre', required=True)
	location = fields.Char(string='Localización', required=True)
	fundation = fields.Date(string='Año fundación', default=datetime.today(), required=True)