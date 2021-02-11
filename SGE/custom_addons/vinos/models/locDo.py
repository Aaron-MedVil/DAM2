# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo localizacion denominacion origen
class doLoc(models.Model):
	_name = 'doloc.vinos'
	_description = 'denominacion_origen_localizacion'

	do = fields.Many2one('do.vinos', string='Denominación origen')
	location = fields.Char(string='Localización')