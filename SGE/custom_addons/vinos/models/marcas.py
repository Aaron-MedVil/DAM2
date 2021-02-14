# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo marca
class marca(models.Model):
	_name = 'marca.vinos'
	_description = 'marca'

	name = fields.Char(string='Nombre', default='', required=True)