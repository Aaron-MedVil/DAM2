# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo variedad
class variedad(models.Model):
	_name = 'variedad.vinos'
	_description = 'variedad'

	name = fields.Char(string='Tipo uva', required=True)