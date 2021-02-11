# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo bodega
class bodega(models.Model):
	_name = 'bodega.vinos'
	_description = 'bodega'

	name = fields.Char(string='Nombre')
	location = fields.Char(string='Localización')
	# fundation = fields.Date(year_selection, string='Año fundación', default='2000')
	fundation = fields.Date(string='Año fundación')