# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo variedad
class variedad(models.Model):
	_name = 'variedad.vinos'
	_description = 'variedad'

	tipo_uva = fields.Char(string='Tipo uva')